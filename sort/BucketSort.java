package sort;

/**
 * 桶排序
 */
public class BucketSort {
    public void buckerSort(int[] arr, int len, int bucketCount) {
        
        // 确定数据的范围
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int i = 1; i < len; ++i) {
            if (arr[i] < minVal) {
                minVal = arr[i];
            } else if (arr[i] > maxVal){
                maxVal = arr[i];
            }
        }
        
        // 确认每个桶的所表示的范围
        bucketCount =  (maxVal - minVal + 1) < bucketCount ? (maxVal - minVal + 1) : bucketCount;
        int bucketSize = (maxVal - minVal + 1) / bucketCount;
        bucketCount = (maxVal -  minVal + 1) % bucketCount == 0 ? bucketCount : bucketCount + 1;

        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];  // 数组位置记录
        
        // 将数据依次放入桶中
        for (int i = 0; i < len; i++) {
            int bucketIndex = (arr[i] - minVal) / bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                expandCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i]; 
        }

        // 桶内排序
        for (int i = 0; i < bucketCount; ++i) {
            if (indexArr[i] != 0) {
                quickSort(buckets[i], 0, indexArr[i] - 1);
            }
        }
        
        // 桶内数据依次取出
        int index = 0;
        for (int i = 0; i < bucketCount; ++i) {
            for (int j = 0; j < indexArr[i]; ++j) {
                arr[index++] = buckets[i][j];
            }
        }

        // 打印
        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // 对数组进行扩容
    public void expandCapacity(int[][] buckets, int bucketIndex) {
        int[] newArr = new int[buckets[bucketIndex].length * 2];
        System.arraycopy(buckets[bucketIndex], 0, newArr, 0, buckets[bucketIndex].length);
        buckets[bucketIndex] = newArr;
    }

    /**
     * 快速排序
     * end：指向最后一个元素
     */
    private void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        // 一定要是 p-1！
        int p = partition(arr, begin, end); // 先进行大致排序，并获取区分点
        quickSort(arr, begin, p-1);
        quickSort(arr, p+1, end);
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

    public static void main(String[] args) {
        int bucketCount = 10;
        int[] arr =  new int[]{1, 3, 4, 8, 5, 2};
        // int[] arr = new int[]{1, 10, 20, 4, 5, 7, 8, 10, 12, 15, 17, 18, 17, 21, 31, 25, 27, 22};
        BucketSort bs = new BucketSort();
        bs.buckerSort(arr, arr.length, bucketCount);
    }
}