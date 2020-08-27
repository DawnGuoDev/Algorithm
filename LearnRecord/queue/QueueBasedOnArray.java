package queue;

public class QueueBasedOnArray {
    private String[] items;     // 数组
    private int head;           // 队头
    private int tail;           // 队尾元素的下一个指针
    private int capacity;       // 队列容量

    public QueueBasedOnArray(int capacity) {
        this.items = new String[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
    }

    public void extendCapacity() {
        String[] temp = new String[this.capacity * 2];
        System.arraycopy(this.items, 0, temp, 0, this.capacity);
        this.items = temp;
        this.head = 0;
        this.tail = this.capacity;
        this.capacity = this.capacity *2;
    }

    public void enQueue(String itemString) {
        if (this.tail == this.capacity && 0 == this.head) {
            extendCapacity();
        } else if (this.tail == this.capacity) {
            System.arraycopy(this.items, this.head, this.items, 0, this.tail - this.head);
            this.tail = this.tail - this.head;
            this.head = 0;
        }

        this.items[this.tail] = itemString;
        this.tail ++;
    }

    public String deQueue(){
        if (this.head == this.tail) {
            return null;
        }

        return this.items[this.head++];
    }

    private void printAll() {
        System.out.println("从队头开始输出队列内容");
        for (int i = this.head; i < this.tail; i++) {
            System.out.println(this.items[i] + "\t");
        }
        System.out.println("输出完毕");
    }

    public static void main(String[] args) {
        QueueBasedOnArray qba = new QueueBasedOnArray(3);
        qba.enQueue("multi");
        qba.enQueue("param");
        qba.enQueue("dawnguo1");
        qba.enQueue("dawnguo2");
        qba.printAll();
        qba.deQueue();
        qba.deQueue();
        qba.printAll();
        qba.enQueue("multi");
        qba.enQueue("param");
        qba.enQueue("multi");
        qba.enQueue("param");
        qba.enQueue("multi");
        
        qba.printAll();
    }
}