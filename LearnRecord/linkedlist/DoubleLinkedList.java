package linkedlist;

public class DoubleLinkedList {
    
    // 没有头结点的话
    private Node head = null;

    public boolean insertToHead(Node newNode) {
        if (newNode == null) {
            return false;
        }

        if (this.head == null) {
            newNode.next = this.head;
            newNode.pre = null;
            this.head = newNode;
            return true;
        }
        
        newNode.next = this.head;
        newNode.pre = null;
        this.head.pre = newNode;
        this.head = newNode;

        return true;
    }

    public boolean insertToTail(Node newNode) {
        if (newNode == null) {
            return false;    
        }

        if (this.head == null) {
            insertToHead(newNode);
            return true;
        }

        Node pNode = this.head;
        while (pNode.next != null) {
            pNode = pNode.next;
        }

        pNode.next = newNode;
        newNode.next = null;
        newNode.pre = pNode;

        return true;
    }

    public boolean insertAfter(Node p, Node newNode){
        if (p == null || newNode == null || this.head == null) {
            return false;
        }

        Node pNode = this.head;

        while (pNode != p && pNode.next != null) {
            pNode = pNode.next;
        }

        if (pNode != p) {
            return false;
        }


        if (pNode.next == null) {
            newNode.next = null;
            newNode.pre = pNode;
            pNode.next = newNode;
            return true;
        }

        // 要注意顺序
        newNode.next = pNode.next;
        pNode.next.pre = newNode;
        newNode.pre = pNode;
        pNode.next = newNode;   

        return true;
    }

    // 第一次实现的时候：没注意在第一个结点之前插入的情况
    public boolean insertBefore(Node p, Node newNode) {
        if (p == null || newNode == null || this.head == null) {
            return false;
        }

        Node pNode = this.head;

        while (pNode != p && pNode.next != null) {
            pNode =  pNode.next;
        }

        if (pNode != p){
            return false;
        }

        if (pNode == this.head) {
            newNode.pre = null;
            newNode.next = pNode;
            pNode.pre = newNode;
            this.head = newNode;
            return true;
        }

        newNode.pre = pNode.pre;
        pNode.pre.next = newNode;
        newNode.next = pNode;
        pNode.pre = newNode;

        return true;
    }

    // 第一次实现的时候：没注意删除第一个结点的情况
    public boolean deleteByNode(Node p) {
        if (p == null || this.head == null) {
            return false;
        }

        Node pNode = this.head;
        while (pNode != p && pNode.next != null) {
            pNode = pNode.next;
        }

        if (pNode != p) {
            return false;
        }
        
        // 考虑找到的情况
        // 位于第一个结点
        if (pNode == this.head) {
            this.head = pNode.next;
            pNode.next.pre = null;
            return true;
        }
        if (pNode.next == null) {
            pNode.pre.next = null;
            pNode.pre = null;
            return true;
        }

        pNode.pre.next = pNode.next;
        pNode.next.pre = pNode.pre;

        return true;
    }

    // 第一次实现的时候：没注意删除第一个结点的情况
    public boolean deleteByValue(int value) {
        if (this.head == null) {
            return false;
        }

        Node pNode = this.head;

        while (pNode.data != value && pNode.next != null) {
            pNode = pNode.next;
        }
        
        if (pNode.data != value) {
            return false;
        }
        
        if (pNode == this.head) {
            this.head = pNode.next;
            pNode.next.pre = null;
            return true;
        }

        if (pNode.next == null) {
            pNode.pre.next = null;
            pNode.pre = null;
            return true;
        }

        pNode.pre.next = pNode.next;
        pNode.next.pre = pNode.pre;

        return true;
    }

    public Node findByValue(int value) {
        if (this.head == null) {
            return null;
        }

        Node pNode = this.head;

        while (pNode.data != value && pNode.next != null) {
            pNode = pNode.next;
        }

        return  pNode;
    }

    // index from 1 to n
    public Node findByIndex(int index) {
        if (this.head == null) {
            return null;
        }

        int i = 1;
        Node pNode = this.head;

        while (i < index && pNode.next != null) {
            i++;
            pNode = pNode.next;
        }
        
        if (i < index) {
            return null;
        }

        return pNode;
    }

    // 打印链表
    public void printAll() {
        Node pNode = this.head;
        while (pNode.next != null) {
            System.out.print(pNode.data + "  ");
            pNode = pNode.next;
        }
        System.out.println(pNode.data);
    }

    public static class Node {
        private Node pre;
        private int data;   // 存储数据
        private Node next;  // 记录后继节点

        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node pre, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // int[] data =  new int[]{1, 2, 3, 4, 5};
        int [] data = {1, 2, 3, 4, 5};
        DoubleLinkedList sl = new DoubleLinkedList();
        
        System.out.println("Test DoubleLinkedList.insertToTail");
        for (int i = 0; i < data.length; i++) {
            sl.insertToTail(new Node(data[i], null, null));
        }
        sl.printAll();

        System.out.println("Test DoubleLinkedList.insertToHead");
        for (int i = 0; i < data.length; i++) {
            sl.insertToHead(new Node(data[i], null, null));
        }
        sl.printAll();

        System.out.println("Test DoubleLinkedList.findByIndex");
        Node node = sl.findByIndex(1);
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("Not found");
        }
        
        System.out.println("Test DoubleLinkedList.findByValue");
        node = sl.findByValue(5);
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("Not found");
        }

        System.out.println("Test DoubleLinkedList.deleteByNode");
        sl.deleteByNode(node);
        node = null;
        sl.printAll();

        System.out.println("Test DoubleLinkedList.deleteByValue");
        sl.deleteByValue(4);
        sl.printAll();

        System.out.println("Test DoubleLinkedList.deleteByValue");
        sl.deleteByValue(4);
        sl.printAll();

        System.out.println("Test DoubleLinkedList.findByValue");
        node = sl.findByValue(5);
        System.out.println(node.data);

        if (node == null) {
            return;
        }
        System.out.println("Test DoubleLinkedList.insertBefore");
        sl.insertBefore(node, new Node(10));
        sl.printAll();

        System.out.println("Test DoubleLinkedList.insertAfrer");
        sl.insertAfter(node, new Node(12));
        sl.printAll();

        System.out.println("Test DoubleLinkedList.deleteByNode");
        sl.deleteByNode(node);
        sl.printAll();
    }
}


