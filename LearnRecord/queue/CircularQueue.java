package queue;

public class CircularQueue {
    private int[] items;
    private int capacity;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        this.items = new int[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
    }

    public boolean isEmpty() {
        return this.head == this.tail;
    }
    
    public boolean isFull() {
        return (this.tail +1) % this.capacity ==  this.head;
    }

    /**
     * 需要考虑 this.tail < this.head 和 this.tail > this.head 两种情况
     */
    public void extendCapacity() {
        int[] temp = new int[this.capacity * 2];

        if (this.tail > this.head) {
            System.arraycopy(this.items, this.head, temp, 0, this.tail - this.head);
            this.tail = this.tail - this.head;
        } else {
            System.arraycopy(this.items, this.head, temp, 0, this.capacity - this.head);
            System.arraycopy(this.items, 0, temp, this.capacity - this.head, this.tail);
            this.tail = this.capacity - (this.head - this.tail);
        }
        this.head = 0;
        this.items = temp;
        this.capacity = this.capacity * 2;
    }

    public void enQueue(int value) {
        if (this.isFull()) {
            extendCapacity();
        }

        this.items[this.tail] = value;
        this.tail = (this.tail + 1) % this.capacity;
    }

    public int deQueue() {
        if (this.isEmpty()){
            System.out.println("Circular queue is empty.");
            return -1;
        }

        int re = this.items[this.head];
        this.head = (this.head + 1) % this.capacity;
        
        return re;
    }

    private void printAll() {
        System.out.println("从 head 开始输出队列内容");
        for (int i = this.head; i < this.tail; i++) {
            System.out.print(this.items[i] + "\t");
        }
        System.out.println();
        System.out.println("head    " + this.head);
        System.out.println("tail    " + this.tail);
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);
        cq.enQueue(1);
        cq.enQueue(2);
        cq.enQueue(3);
        cq.enQueue(4);
        cq.printAll();
        
        cq.deQueue();
        cq.deQueue();
        cq.printAll();

        cq.enQueue(5);
        cq.enQueue(6);
        cq.enQueue(7);
        cq.enQueue(8);
        cq.printAll();
    }
}