package MethodFirst;

import java.util.HashMap;

class LRUCache {
    private HashMap<Integer, Node> map;
    private int capacity;
    private DoubleList doubleList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.doubleList = new DoubleList();
    }

    public int get(int key) {
        Node node = map.get(key);

        if (node == null) {
            return -1;
        } else {
            doubleList.moveFist(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        
        // 假如不存在 key 为 key 的节点，则添加
        if (node == null) {
            Node newNode = new Node(key, value);
            if (doubleList.getSize() == this.capacity) {
                Node last = doubleList.removeLast();
                map.remove(last.key);
            }
            
            // 链表这边需要添加，hashmap 这边也需要添加
            doubleList.addFirst(newNode);
            map.put(key, newNode);
        } else {
            node.value = value;
            doubleList.moveFist(node);
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

class Node {
    int key;
    int value;

    Node prev;
    Node next;

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public Node(int key, int value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    } 
}

class DoubleList {
    private Node head;
    private Node tail;
    private int len;

    public DoubleList() {
        this.head = new Node();
        this.tail = new Node();

        this.head.prev = null;
        this.head.next = this.tail;

        this.tail.prev = this.head;
        this.tail.next = null;
        
        this.len = 0;
    }

    public void addFirst(Node node) {
        if (node == null) {
            return;
        }

        node.next = this.head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;

        this.len ++;
    }

    public void moveFist(Node node) {
        if (node == null) {
            return;
        }

        if (node.prev == this.head) {
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;

        // 这边要记得减一否则，因为上面相当删除这个节点
        this.len --;

        // 重新添加这个节点
        this.addFirst(node);
    }

    public Node removeLast() {
        if (this.tail.prev == this.head) {
            return null;
        }

        Node node = this.tail.prev;

        node.next = null;
        this.tail.prev = node.prev;
        node.prev.next = this.tail;        
        node.prev = null;

        this.len --;
        
        return node;
    }

    public int getSize() {
        return this.len;
    }
}