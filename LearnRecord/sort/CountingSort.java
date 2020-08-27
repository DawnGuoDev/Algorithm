package sort;

public class CountingSort {
    
    /**
     * 计数排序，暂时只能处理整数（包括整数和负数）
     * @param arr
     * @param len
     */
    public void countingSort(int[] arr, int len) {
        // 确定范围
        int minVal = arr[0];
        int maxVal = arr[0];
        for (int i = 1; i < len; ++i) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            } else if (arr[i] < minVal) {
                minVal = arr[i];
            }
        }

        // 对数据进行处理
        for (int i = 0; i < len; ++i) {
            arr[i] = arr[i] - minVal;
        }
        maxVal = maxVal - minVal;

        // 遍历数据数组，求得计数数组的个数
        int[] count = new int[maxVal + 1];
        for (int i = 0; i < len; ++i) {
            count[arr[i]] ++;
        }
        printAll(count, maxVal + 1);

        // 对计数数组进行优化
        for (int i = 1; i < maxVal + 1; ++i) {
            count[i] = count[i - 1] + count[i];
        }
        printAll(count, maxVal + 1);

        // 进行排序，从后往前遍历（为了稳定）
        int[] sort = new int[len];
        for (int i = len - 1; i >= 0; --i) {
            sort[count[arr[i]] - 1] = arr[i] + minVal;
            count[arr[i]]--;
        }
        printAll(sort, len);
    }

    public void printAll(int[] arr, int len) {
        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{2, 5, 3, 4, 2, 3, 4};
        CountingSort cs = new CountingSort();
        cs.countingSort(arr, arr.length);
    }

}