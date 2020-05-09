package sort;

public class Sort {

    /**
     * 冒泡排序：
     * 以升序为例，就是比较相邻两个数，如果逆序就交换，类似于冒泡；
     * 一次冒泡确定一个数的位置，因为要确定 n-1 个数，因此需要 n-1 
     * 次冒泡；
     * 冒泡排序时，其实相当于把整个待排序序列分为未排序区和已排序区
     */
    public void bubbleSort(int[] arr, int len) {
        // len-1 趟
        for (int j = 0; j < len-1; j++) {
            int sortedFlag = 0;
            // 一趟冒泡
            for (int i = 0; i < len-1-j; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sortedFlag = 1;
                }
            }

            // 该趟排序中没有发生，表示已经有序
            if (0 == sortedFlag) {
                break;
            }
        }
    }

    /**
     * 选择排序：
     * 选择排序将待排序序列分成未排序区和已排序区；
     * 第一趟排序的时候整个待排序序列是未排序区；
     * 每一趟排序其实就是从未排序区选择一个最值，放到已排序区；
     * 跑 len-1 趟就好
     */
    public void switchSort(int[] arr, int len) {
        // len-1 趟，0-i 为已排序区
        for (int i = 0; i < len-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * 插入排序：
     * 插入排序也相当于把待排序序列分成已排序区和未排序区；
     * 每趟排序都将从未排序区选择一个元素插入到已排序合适的位置；
     * 假设第一个元素属于已排序区，那么还需要插入 len-1 趟；
     */
    public void insertSort(int[] arr, int len) {
        // len-1 趟
        for (int i = 1; i < len; i++) {
            // 一趟排序
            int temp = arr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] arr, int len) {
        __mergerSort(arr, 0, len-1);
    }

    private void __mergerSort(int[] arr, int begin, int end) {
        if (begin == end){
            return;
        }

        __mergerSort(arr, begin, (begin+end)/2);
        __mergerSort(arr, (begin+end)/2 + 1, end);
        merge(arr, begin, end);
        return;
    }

    private void merge(int[] arr, int begin, int end) {
        int[] copyArr = new int[end-begin+1];
        System.arraycopy(arr, begin, copyArr, 0, end-begin+1);

        int mid = (end - begin + 1)/2;
        int i = 0;  // begin - mid 的指针
        int j =  mid;   // mid - end 的指针
        int count = begin;  // 合并之后数组的指针

        while (i <= mid-1 && j <= end - begin) {
            arr[count++] = copyArr[i] < copyArr[j] ? copyArr[i++] : copyArr[j++];
        }

        while (i <= mid-1) {
            arr[count++] = copyArr[i++];
        }

        while (j <= end - begin) {
            arr[count++] = copyArr[j++];
        }
    }

    /**
     * 快速排序
     */
    public void quickSort(int[] arr, int len) {
        __quickSort(arr, 0, len-1);
    }

    // 注意边界条件
    private void __quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        // 一定要是 p-1！
        int p = partition(arr, begin, end); // 先进行大致排序，并获取区分点
        __quickSort(arr, begin, p-1);
        __quickSort(arr, p+1, end);
    }

    private int partition(int[] arr, int begin, int end) {
        int pValue = arr[end];

        // 整两个指针，两个指针都从头开始
        // begin --- i-1（含 i-1）： 小于 pValue 的区
        // i --- j-1（含 j-1）：大于 pValue 的区
        // j --- end：未排序区
        int i = begin;
        int j = begin;
        while (j <= end) {
            if (arr[j] <= pValue) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i-1;
    }

    public void printAll(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{67, 4, 58, 3, 98, 5, 87, 7};
        Sort sort = new Sort();
        // sort.bubbleSort(arr, arr.length);
        // sort.switchSort(arr, arr.length);
        // sort.insertSort(arr, arr.length);
        // sort.printAll(arr, arr.length);
        // sort.merge(arr, 0, arr.length - 1);
        // sort.mergeSort(arr, arr.length);
        sort.quickSort(arr, arr.length);        
        sort.printAll(arr, arr.length);
    }
}