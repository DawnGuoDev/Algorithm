package stack;

public class StackBasedOnArray {
    private int[] items;           // 数组
    private int point;             // 栈顶位置
    private int capacity;          // 栈的容量

    public StackBasedOnArray(int capacity) {
        this.capacity = capacity;
        this.items = new int[this.capacity];
        this.point = 0;
    }

    public void externCapacity() {
        int[] temp = new int[this.capacity * 2];
        System.arraycopy(this.items, 0, temp, 0, this.capacity);
        this.items = temp;
        this.capacity = this.capacity * 2;
    }

    // 入栈
    public void push(int item) {
        if (this.point == this.capacity - 1) {
            externCapacity();
        }
        this.items[this.point] = item;
        this.point ++;
    }

    // 出栈
    public int pop() {
        if (this.point == 0) {
            return -1;
        }

        this.point --;
        return this.items[this.point];
    }

    private void printAll() {
        System.out.println("从栈底往上依次输出元素");
        for(int i = 0; i < this.point; i++) {
            System.out.print(this.items[i] + "\t");
        }
        System.out.println("\n输出完成");
    }

    public static void main(String[] args) {
        StackBasedOnArray sboa = new StackBasedOnArray(4);
        sboa.push(1);
        sboa.push(2);
        sboa.push(3);
        sboa.push(2);
        sboa.push(3);
        sboa.printAll();
        sboa.pop();
        sboa.push(9);
        sboa.printAll();
        sboa.pop();
        sboa.pop();
        sboa.printAll();
        sboa.pop();
        sboa.printAll();
    }
}