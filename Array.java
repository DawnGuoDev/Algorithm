package algo_learn;

public class Array {
    // 整形数组 data 保存数据
    public int[] data;
    // 数组长度
    private int capacity;
    // 实际个数
    private int count;

    /**
     * 构造方法
     */
    public Array(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.count = 0; // 当前数组已存数据个数
    } 
    
    /**
     * 根据 index 查找元素
     */
    public int find(int index){
        if (index < 0 || index >= this.count) {
            return -1;
        }
        return this.data[index];
    }

    /** 
     * 采用头插法:
     * 即插入 0 位置，那么 0 开始的数组依次往后移 
     */
    public boolean insert(int index, int value) {
        if (index < 0 || index > this.count) {
            System.out.println("插入位置不合法");
            return false;
        }

        if (this.count == this.capacity) {
            this.externCapacity();
        }
        
        for (int i = this.count; i > index; i--) {
            this.data[i]  = this.data[i-1];
        }
        data[index]  = value;
        this.count++;

        return true;
    }

    /**
     * 插入的是整个数组，也就是将两个数组合并
     */
    public void insertArray(int[] append) {
        int lenData = this.count;
        int lenAppend = append.length;
        int[] dataCopy = new int[lenData];
        System.arraycopy(this.data, 0, dataCopy, 0, lenData);
        int p1 = 0; // datacopy 的指针
        int p2 = 0; // append 的指针
        this.count = 0;
        while((p1 < lenData) && (p2 < lenAppend)) {
            if (dataCopy[p1] < append[p2]) {
                insert(this.count, dataCopy[p1]);
                p1++;
            }else {
                insert(this.count, append[p2]);
                p2++;
            }
        }

        while(p1 < lenData) {
            insert(this.count, dataCopy[p1]);
            p1++;
        }

        while(p2 < lenAppend) {
            insert(this.count, append[p2]);
            p2++;
        }
    }

    /**
     * 删除元素
     */
    public boolean delete(int index) {
        if (index < 0 || index >= this.count) {
            return false;
        }
        
        for (int i = index; i < this.count - 1; i++){
            this.data[i] = this.data[i+1];
        }
        this.count --;
        
        return true;
    }

    /**
     * 修改元素，O(1)
     */
    public boolean modify(int index, int value) {
        if (index < 0 || index >= this.count) {
            return false;
        }

        this.data[index] = value;
        
        return true;
    }

    /**
     * 对数组进行扩容,O(n)
     */
    private void externCapacity() {
        this.capacity = this.capacity * 2 ;   // 存储容量变大

        // 拷贝数据
        int[] oldData = this.data;
        this.data = new int[this.capacity];
        for(int i = 0; i < this.count; i++) {
            this.data[i]  = oldData[i];
        }

    }

    /**
     * 打印数组内容，O(n)
     */
    public void printAll(){
        for (int i = 0; i < this.count; i++) {
            System.out.printf("%d \t", this.data[i]);
        }
        System.out.println();
    }
}