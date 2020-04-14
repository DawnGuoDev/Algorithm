package linkedlist;

/**
 * summary:
 *  1. 对于插入位置已经确定了的，比如 insertToHead 或者 insertToTail 来说，
 *     需要考虑是不是第一个插入的问题；
 *  2. 对于插入位置不确定的，比如 insertAfter insertBefore 来说，
 *     需要考虑插入的位置，个人觉得分别三个，第一个结点、中间结点、尾结点；
 *  3. 对于删除位置不确定的，需要考虑删除的位置。
 *  4. 对于查找来说，需要考虑情况，比如是否是空链表、除了判断值之外还得进行
 *     尾结点的判断，以及怎样才算找到，怎么又是没找到。
 *     当然这些其实对于插入位置不确定和删除位置不确定来说都是需要考虑的。
 */
public class CircularLinkedList {
    // 没有头结点的话
    private Node head = null;

    // 插入头的情况下：首先需要考虑是不是第一个插入，位置已经确定了
    public boolean insertToHead(Node newNode) {
        if (newNode == null) {
            return false;
        }

        // 改变 head 的指向
        newNode.next = this.head;
        this.head = newNode;
        
        
        // 改变尾结点的指向
        if (newNode.next == null) { // 插入的是第一个结点
            newNode.next = this.head;
            return true;
        }

        Node p = this.head.next;
        while (p.next != newNode.next) {  
            p = p.next;
        }

        p.next = this.head;
    
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
        while (p.next != this.head) {
            p = p.next;
        } // 退出循环之后，p 指向了最后一个节点
        p.next = newNode;
        newNode.next = this.head;

        return true;
    }

    public boolean insertAfter(Node p, Node newNode){
        if (p == null || newNode == null) {
            return false;
        }
        
        // 先确保 p 在不在该链表中
        Node qNode = this.head;
        if (qNode == null) {    // 链表为空
            return false;
        }

        // 链表不为空，遍历寻找
        while (qNode != p && qNode.next != this.head) {
            qNode = qNode.next;
        }

        // 没找到 p
        if (qNode != p) {
            return false;
        }

        // 注意顺序，防止丢失
        newNode.next = p.next;
        p.next = newNode;

        return true;
    }

    public boolean insertBefore(Node p, Node newNode) {
        if (p == null || newNode == null) {
            return false;
        }
        
        // 需要先找到 p 的前驱节点
        Node pNode= this.head;
        Node qNode = null;

        // 空链表的情况
        if (pNode == null) {
            return false;
        }

        while (pNode != p && pNode.next != this.head ) {
            qNode = pNode;
            pNode = pNode.next;
        }   // 循环退出之后可能是找到了，也可能是没找到
        
        // 表示没找到
        if (pNode != p) {
            return false;
        }

        // 找到的情况下
        if (qNode == null) {    // 找到的是第一个结点的情况
            insertToHead(newNode);
        } else {
            newNode.next = qNode.next;
            qNode.next = newNode;
        }

        return true;
    }

    public boolean deleteByNode(Node p) {
        if (p == null) {
            return false;
        }

        // 同样是先需要找到 p 的前驱结点
        Node pNode = this.head;
        Node qNode = null;
        // 空链表的情况
        if (pNode == null) {
            return false;
        }

        while (pNode != p && pNode.next != this.head) {
            qNode = pNode;
            pNode =  pNode.next;
        }

        // 没找到
        if (pNode != p) {
            return false;
        }
        
        
        if (qNode == null) {    // 处于头结点情况，记得改变尾结点
            this.head = pNode.next;
            qNode = this.head;
            while (qNode.next != pNode) {
                qNode = qNode.next;
            }
            qNode.next = this.head;
            return true;
        } 
        
        qNode.next = pNode.next;
       
        return true;
    }


    public boolean deleteByValue(int value) {
        Node pNode = this.head;
        Node qNode = null;  // 继续 p 的前驱结点
        
        // 空链表情况
        if (pNode == null) {
            return false;
        }

        while (pNode.data != value && pNode.next != this.head) {
            qNode = pNode;
            pNode = pNode.next;
        }
        
        if (pNode.data != value) {
            return false;
        }

        if (qNode == null) {
            this.head = pNode.next;
            qNode = this.head;
            while (qNode.next != pNode) {
                qNode = qNode.next;
            }
            qNode.next = this.head;
            return true;
        }

        qNode.next = pNode.next;

        return true;
    }

    public Node findByValue(int value) {
        Node pNode = this.head;
        
        if (pNode ==  null) {
            return null;
        }
        
        while (pNode.data != value && pNode.next != this.head) {
            pNode =  pNode.next;
        }

        if (pNode.data != value) {
            return null;
        }

        return pNode;
    }

    // index from 1 to n
    public Node findByIndex(int index) {
        Node pNode = this.head;

        if (pNode == null) {
            return null;
        }

        int i = 1;
        while (i < index && pNode.next != this.head) {
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

        if (pNode == null) {
            return;
        }

        while (pNode.next != this.head) {
            System.out.print(pNode.data + " ");
            pNode = pNode.next;
        }
        System.out.println(pNode.data);
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
        CircularLinkedList cl = new CircularLinkedList();
        
        System.out.println("Test SingleLinkedList.insertToTail");
        for (int i = 0; i < data.length; i++) {
            cl.insertToTail(new Node(data[i], null));
        }
        cl.printAll();

        System.out.println("Test SingleLinkedList.insertToHead");
        for (int i = 0; i < data.length; i++) {
            cl.insertToHead(new Node(data[i], null));
        }
        cl.printAll();

        System.out.println("Test SingleLinkedList.findByIndex");
        Node node = cl.findByIndex(1);
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("Not found");
        }
        
        System.out.println("Test SingleLinkedList.findByValue");
        node = cl.findByValue(4);
        if (node != null) {
            System.out.println(node.data);
        } else {
            System.out.println("Not found");
        }

        System.out.println("Test SingleLinkedList.deleteByNode");
        cl.deleteByNode(node);
        node = null;
        cl.printAll();

        System.out.println("Test SingleLinkedList.deleteByValue");
        cl.deleteByValue(5);
        cl.printAll();

        System.out.println("Test SingleLinkedList.findByValue");
        node = cl.findByValue(5);
        System.out.println(node.data);

        if (node == null) {
            return;
        }
        System.out.println("Test SingleLinkedList.insertBefore");
        cl.insertBefore(node, new Node(10));
        cl.printAll();

        System.out.println("Test SingleLinkedList.insertAfrer");
        cl.insertAfter(node, new Node(12));
        cl.printAll();

        System.out.println("Test SingleLinkedList.deleteByNode");
        cl.deleteByNode(node);
        cl.printAll();
    }
}