package linkedlist;

public class SingleLinkedList {
    
    // 没有头结点的话
    private Node head = null;

    public boolean insertToHead(Node newNode) {
        if (newNode == null) {
            return false;
        }

        newNode.next = this.head;
        this.head = newNode;

        return true;
    }

    public boolean insertToTail(Node newNode) {
        if (newNode == null) {
            return false;
        }
        
        Node p = this.head;
        // 假如为空链表
        if (p == null) {
            insertToHead(newNode);
            return true;
        }

        // 不是空链表，先找到最后一个节点
        while (p.next != null) {
            p = p.next;
        } // 退出循环之后，p 指向了最后一个节点
        p.next = newNode;

        return true;
    }

    public boolean insertAfter(Node p, Node newNode){
        if (p == null || newNode == null) {
            return false;
        }
        
        // 注意顺序，防止丢失
        newNode.next = p.next;
        p.next = newNode;

        return true;
    }

    // 第一次实现的时候：没注意在第一个结点之前插入的情况
    public boolean insertBefore(Node p, Node newNode) {
        if (p == null || newNode == null) {
            return false;
        }
        
        // 需要先找到 p 的前驱节点
        Node pNode= this.head;
        Node qNode = null;
        while (pNode != null && pNode != p) {
            qNode = pNode;
            pNode = pNode.next;
        }   // 循环退出之后可能是找到了，也可能是为空了
        
        if (pNode == null) {
            return false;
        }

        // 找到了的情况
        newNode.next = pNode;
        if (qNode == null) {
            this.head = newNode;
        } else {
            qNode.next =  newNode;
        }
        

        return true;
    }

    // 第一次实现的时候：没注意删除第一个结点的情况
    public boolean deleteByNode(Node p) {
        if (p == null) {
            return false;
        }

        // 同样是先需要找到 p 的前驱结点
        Node pNode = this.head;
        Node qNode = null;
        while (pNode != null && pNode != p) {
            qNode = pNode;
            pNode =  pNode.next;
        }

        if (pNode == null) {
            return false;
        }

        if (qNode == null) {    // 处于头结点情况
            this.head = pNode.next;
        } else {
            qNode.next = pNode.next;
        }
       
        return true;
    }

    // 第一次实现的时候：没注意删除第一个结点的情况
    public boolean deleteByValue(int value) {
        Node p = this.head;
        Node q = null;  // 继续 p 的前驱结点
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        
        if (p == null) {
            return false;
        }

        if (q == null) {
            this.head = p.next;
        } else {
            q.next = p.next;
        }

        return true;
    }

    public Node findByValue(int value) {
        Node p = this.head;
        while (p != null && p.data != value) {
            p = p.next;
        }

        if (p == null) {
            return null;
        }
        
        return p;
    }

    // index from 1 to n
    public Node findByIndex(int index) {
        Node p = this.head;
        int i = 1;
        while (i < index && p.next != null) {
            i++;
            p = p.next;
        }

        if (i == index) {
            return p;
        }

        return null;
    }

    // 打印链表
    public void printAll() {
        Node p = this.head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;   // 存储数据
        private Node next;  // 记录后继节点

        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // int[] data =  new int[]{1, 2, 3, 4, 5};
        int [] data = {1, 2, 3, 4, 5};
        SingleLinkedList sl = new SingleLinkedList();
        
        System.out.println("Test SingleLinkedList.insertToTail");
        for (int i = 0; i < data.length; i++) {
            sl.insertToTail(new Node(data[i], null));
        }
        sl.printAll();

        System.out.println("Test SingleLinkedList.insertToHead");
        for (int i = 0; i < data.length; i++) {
            sl.insertToHead(new Node(data[i], null));
        }
        sl.printAll();

        System.out.println("Test SingleLinkedList.findByIndex");
        Node node = sl.findByIndex(1);
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("Not found");
        }
        
        System.out.println("Test SingleLinkedList.findByValue");
        node = sl.findByValue(4);
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("Not found");
        }

        System.out.println("Test SingleLinkedList.deleteByNode");
        sl.deleteByNode(node);
        node = null;
        sl.printAll();

        System.out.println("Test SingleLinkedList.deleteByValue");
        sl.deleteByValue(4);
        sl.printAll();

        System.out.println("Test SingleLinkedList.deleteByValue");
        sl.deleteByValue(4);
        sl.printAll();


        System.out.println("Test SingleLinkedList.findByValue");
        node = sl.findByValue(3);
        System.out.println(node.data);

        if (node == null) {
            return;
        }
        System.out.println("Test SingleLinkedList.insertBefore");
        sl.insertBefore(node, new Node(10));
        sl.printAll();

        System.out.println("Test SingleLinkedList.insertAfrer");
        sl.insertAfter(node, new Node(12));
        sl.printAll();

        System.out.println("Test SingleLinkedList.deleteByNode");
        sl.deleteByNode(node);
        sl.printAll();
    }
}


