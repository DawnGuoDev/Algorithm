package heap;

public class Heap {
    private int[] heap;    // 存储堆
    private int capacity;   // 堆的容量
    private int count;      // 堆中元素的计数

    public Heap() {
        this.capacity = 10;
        this.heap = new int[this.capacity + 1];
        this.count = 0;
    }

    public Heap(int capacity) {
        this.heap = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }
    
    /**
     * 往堆中添加元素
     * 以大顶堆为例
     * @param data
     */
    public void insert(int data) {
        if (this.count >= this.capacity) {
            return;
        }
        ++this.count;
        this.heap[this.count] = data;
        heapifyFromBottom();
    }

    /**
     * 从堆中删除元素
     */
    public void delete () {
        if (this.count <= 0) {
            return;
        }

        this.heap[1] = this.heap[this.count--];
        
        heapifyFromTop(1);
    }

    /**
     * 根据一组数据创建堆
     * @param datas
     */
    public void buildHeap(int[] datas, int len) {
        this.heap = datas;
        this.capacity = len - 1;
        this.count = len - 1;
        for (int i = this.count/2; i >=1; i--) {
            heapifyFromTop(i);
        }
    }

    /**
     * 堆排序
     */
    public void heapSort() {
        while (this.count > 1) {
            swap(this.count, 1);
            this.count--;
            heapifyFromTop(1);
        }
    }

    /**
     * 从上往下实现堆化
     * @param begin
     */
    public void heapifyFromTop(int begin) {
       while (true) {
           int i = begin;   // i 是节点及其左右子节点中较大值的那个节点的下标

           /* 就是在节点及其左右子节点中选择一个最大的值，与节点所处的位置进行；
              但是，需要注意的是假如这个值正好是节点本身，那么直接退出循环；
              否则需要进行交换，然后从交换之后的节点开始继续堆化 */
           if (begin * 2 <= this.count && this.heap[begin] < this.heap[2 * begin]) {
                i = 2 * begin;
           }
           
           if ((2 * begin + 1) <= this.count && this.heap[i] < this.heap[2 * begin + 1]) {
               i = 2 * begin + 1;
           }

           if (i == begin) {
               break;
           }

           swap(begin, i);

           begin = i;
       }
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int get() {
        if (this.count <= 0 ) {
            return -1;
        }
        return this.heap[this.count];
    }

    /**
     * 交换 i 处和 j 处的元素
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i == j) {
            return;
        }

        int temp;
        temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
        
        return;
    }

    /**
     * 从下往上实现堆化
     */
    public void heapifyFromBottom() {
        int i = this.count;
        while (i/2 > 0 && this.heap[i] > this.heap[i/2]) {
            swap(i, i/2);
            i = i/2;
        }
    }
    
    /**
     * 输出堆的情况
     * 直接打印数组（层次遍历）
     */
    public void print() {
         for (int i = 1; i <= this.count; i++) {
             System.out.print(this.heap[i] + " ");
         }
         System.out.println();
    }

    /**
     * 输出堆的情况
     * @param len
     */
    public void print(int len) {
        for (int i = 1; i <= len-1; i++) {
            System.out.print(this.heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Heap heap = new Heap();
        // heap.insert(1);
        // heap.insert(2);
        // heap.insert(3);
        // heap.print();
        // heap.delete();
        // heap.delete();
        // heap.delete();
        // heap.print();

        int[] datas = {0, 7, 5, 19, 8, 4, 1, 20, 13, 16};
        Heap heap = new Heap();
        heap.buildHeap(datas, datas.length);
        heap.print();
        heap.heapSort();
        heap.print(datas.length);
    }
}