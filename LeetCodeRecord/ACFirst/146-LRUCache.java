package ACFirst;

import java.util.HashMap;

class LRUCache {
    private int capacity;
    private HashMap<Integer, DoubleListNode> map;
    private DoubleLinkedList lru;

    public LRUCache() {
        this.capacity = 0;
        this.map = null;
        this.lru = null;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, DoubleListNode>();
        this.lru = new DoubleLinkedList();
    }   
    
    public int get(int key) {
        DoubleListNode node = this.map.get(key);
        
        if (node == null) {
            return -1;
        } else {
            this.lru.moveHead(node);
            
            return node.value;
        }
    }

    public void put(int key, int value) {
        DoubleListNode node = this.map.get(key);

        if (node == null) {
            // 已达到 LRU 的容量了
            if (lru.getLen() >= this.capacity) {
                DoubleListNode deleteNode = this.lru.deleteLast();
                this.map.remove(deleteNode.key); 
            }

            DoubleListNode newNode = new DoubleListNode(key, value);
            this.lru.addFirst(newNode);
            this.map.put(key, newNode);
        } else {
            node.value = value;
            this.lru.moveHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

class DoubleLinkedList {
    private DoubleListNode head = null;
    private DoubleListNode tail = null;
    private int length = 0;

    public DoubleLinkedList() {
        this.head = new DoubleListNode();
        this.tail = new DoubleListNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.length = 0;
    }

    public void addFirst(DoubleListNode node) {
        if (node == null || node == this.head || node == this.tail) {
            return;
        }

        this.head.next.prev = node;
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next = node;
        
        this.length++;
    }

    public void moveHead(DoubleListNode node) {
        if (node == null || node == this.head || node == this.tail) {
            return;
        }

        // 先删除节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        this.length --;

        // 再添加节点
        this.addFirst(node);
    }

    public DoubleListNode deleteLast() {
        if (this.head.next == this.tail) {
            return null;
        }

        DoubleListNode node = this.tail.prev;
        this.tail.prev = node.prev;
        node.prev.next = this.tail;
        node.next = null;
        node.prev = null;

        this.length--;

        return node;
    } 

    public int getLen() {
        return this.length;
    }
}

class DoubleListNode {
    int key;
    int value;
    DoubleListNode prev;
    DoubleListNode next;

    public DoubleListNode() {
        this.key = -1;
        this.value = -1;
        this.prev = null;
        this.next = null;
    }

    public DoubleListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public DoubleListNode(int key, int value, DoubleListNode prev, DoubleListNode next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}