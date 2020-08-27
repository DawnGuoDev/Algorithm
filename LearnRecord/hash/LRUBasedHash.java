package hash;

public class LRUBasedHash<K, V> {
    /**
     * 散列表默认长度
     */
    private static final int DEFAULT_INITAL_CAPACITY = 8;

    /**
     * 装载因子
     */
    private static final float LOAD_FACTOR = 0.75f;

    /**
     * LRU 最大长度
     */
    private static final int LRU_MAX = 8;

    /**
     * 散列表数组
     */
    private Node<K, V>[] table;

    /**
     * 实际元素个数
     */
    private int size;

    /**
     * 链表的头节点
     */
    private Node<K, V> head;

    /**
     * 链表的尾节点
     */
    private Node<K,V> tail;

    static class Node<K, V> {
        K key;  
        V value;

        Node<K, V> prev;    // 前驱节点
        Node<K, V> next;    // 后继节点

        Node<K, V> hnext;   // 拉链的后继结点

        Node() {

        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUBasedHash() {
        this.table = (Node<K, V>[])new Node[this.LRU_MAX];
    }

    /**
     * 散列函数
     * @param o
     * @return
     */
    private int hash(Object o) {
        int h;
        return o == null ? 0 : ((h = o.hashCode()) ^ (h >>> 16)) & (this.table.length - 1);
    } 

    /**
     * 从散列表中获取 key 的 Node 节点
     */
    private Node<K, V> getFromHash(K key) {
        int index = hash(key); 
        Node<K, V> node = this.table[index];

        while (node != null && node.key != key) {
            node = node.hnext;
        }
        
        if (node == null) {
            return  null;
        }

        return node;
    }

    /**
     * 将节点放入散列表的拉链中
     * 在这个函数之前需要已经对插入的节点进行判断了
     * @param node
     */
    private void putIntoHash(Node<K, V> node) {
        int index = hash(node.key);
        Node<K, V> temp = this.table[index];

        this.table[index] = node;
        node.hnext = temp;
        this.size ++;
    }

    /**
     * 将节点从散列表中的拉链中删除
     * @param key
     */
    private void removeFromHash(K key) {
        int index = hash(key);
        Node<K, V> node = this.table[index];
        
        if (null == node) {
            return;
        }

        if (node.key == key) {
            this.table[index] = node.hnext;
            this.size --;
            return;
        }

        Node<K, V> temp = this.table[index].hnext;
        while (temp != null) {
            if (temp.key == key) {
                node.hnext = temp.hnext;
                this.size --;
                return;
            }
            node = node.hnext;
            temp = temp.hnext;
        }
    }
    
    /**
     * 从 LRU 链表中删除尾结点，这是在容量不够的情况下
     */
    private Node<K, V> popTail() {
        if (null == this.tail) {
            return null;
        }

        Node<K, V> temp = this.tail;
        this.tail.prev.next = null;
        this.tail = this.tail.prev;
        temp.prev = null;
        temp.next = null;
        
        return temp;
    }

    /**
     * 将节点移到 LRU 链表的首节点
     */
    private void moveToHead(Node<K, V> node) {
        if (null == node || null == this.head) {
            return;
        }

        if (node == this.head) {
            return;
        }

        if (node == this.tail) {
            node.prev.next = null;
            this.tail = node.prev;
            node.next = this.head;
            node.prev = null;
            this.head.prev = node;
            this.head = node;
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = this.head;
        node.prev = null;
        this.head.prev = node;
        this.head = node;
    }

    
    /**
     * 将节点添加到 LRU 链表中
     * @param node
     */
    private void addNode(Node<K, V> node) {
        if (null == node) {
            return;
        }

        // 这边需要考虑是不是第一个插入节点的情况
        if (null == this.head) {
            this.head = node;
            this.tail = node;
            node.next = null;
            node.prev = null; 
            return;
        }

        node.next = this.head;
        node.prev = null;
        this.head.prev = node;
        this.head = node;
    } 

    /**
     * 将节点从 LRU 链表中移除
     * @param node
     */
    private void removeNode(Node<K, V> node) {
        if (null == node) {
            return;
        }

        // 链表第一个节点的情况
        if (node == this.head) {
            this.head = node.next;
            node.prev = null;
            node.next = null;
            
            this.tail = (this.head != null ? this.tail : null);
            return;
        }

        // 链表最后一个节点的情况
        if (node == this.tail) {
            node.prev.next = null;
            this.tail = node.prev;
            node.prev = null;
            node.next = null;
            return;
        }

        // 其他情况
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 插入节点
     * 首先查询是否存在该节点，如果存在则将其移到链表头部。
     * 如果不存在则添加，hash 中需要添加，链表中需要添加到头部。
     * 添加的时候需要注意先判断是否达到缓存的容量，如果达到则
     * 先将尾部节点删除，然后再添加进去。
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Node<K, V> node = this.getFromHash(key);
        if (null == node) {
            Node<K, V> newNode = new Node<>(key, value);
            
            
            // 这边需要注意
            if (this.size >= this.LRU_MAX) {
                Node<K, V> temp = this.popTail();
                this.removeFromHash(temp.key);
            }

            this.addNode(newNode);
            this.putIntoHash(newNode);
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * 访问（获取）节点，此时 hash 表中可以不变，
     * 访问记得使用 hash 表，访问之后需要将节点
     * 移到链表头部。
     */
    public V get(K key) {
        Node<K, V> node = this.getFromHash(key);
        if (null == node) {
            return null;
        }

        this.moveToHead(node);
        return node.value;
    }
    
    
    /**
     * 删除节点，先找到该节点，如果找到了则删除，
     * 记得从链表中也要删除
     * @param key
     */
    public void remove(K key) {
        Node<K, V> node = this.getFromHash(key);

        if (null == node) {
            return;
        }

        this.removeFromHash(node.key);
        this.removeNode(node);
    }

    /**
     * 按照 LRU 的顺序输出，即访问时间
     */
    public void printAll() {
        Node<K, V> p =  this.head;
        while (p != null) {
            System.out.println(p.key + " " + p.value);
            p = p.next;
        }
        System.out.println("-----------------");
    }


    public static void main(String[] args) {
        LRUBasedHash<Integer, Integer> lbh = new LRUBasedHash<>();
        lbh.put(3, 1);
        lbh.put(2, 3);
        lbh.put(4, 5);
        lbh.printAll();
        lbh.put(2, 8);
        lbh.printAll();
        lbh.get(3);
        lbh.printAll();
        lbh.put(5, 6);
        lbh.printAll();
        lbh.remove(3);
        lbh.printAll();
        // for (int i = 0; i < 20; i++) {
        //     lbh.put(i, i);
        // }
        // lbh.printAll();

        // for (int i = 0; i < 20; i++) {
        //     lbh.remove(i);
        // }
        // lbh.printAll();

        // for (int i = 0; i < 20; i++) {
        //     lbh.get(i);
        // }
        // lbh.printAll();
        
    }
}