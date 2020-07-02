package sort;

/**
 * 基数排序
 */

public class RadixSort {

    /**
     * 基数排序
     * @param arr
     * @param len
     */
    public void radixSort(int[] arr, int len, int bitCount) {
        int exp = 1;
        for (int i = 0; i < bitCount; ++i) {
            countingSort(arr, len, exp);
            exp = exp * 10;
        }
    }

    public int getBit(int value, int exp) {
        return (value / exp) % 10;
    }
    /**
     * 计数排序，暂时只能处理整数（包括整数和负数）
     * @param arr
     * @param len
     */
    public void countingSort(int[] arr, int len, int exp) {

        // 确定范围
        int maxVal = getBit(arr[0], exp);
        for (int i = 1; i < len; ++i) {
            if (maxVal < getBit(arr[i], exp)) {
                maxVal = getBit(arr[i], exp);
            }
        }

        // 遍历数据数组，求得计数数组的个数
        int[] count = new int[maxVal + 1];
        for (int i = 0; i < len; ++i) {
            count[getBit(arr[i], exp)] ++;
        }

        // 对计数数组进行优化
        for (int i = 1; i < maxVal + 1; ++i) {
            count[i] = count[i - 1] + count[i];
        }

        // 进行排序，从后往前遍历（为了稳定）
        int[] sort = new int[len];
        for (int i = len - 1; i >= 0; --i) {
            sort[count[getBit(arr[i], exp)] - 1] = arr[i];
            count[getBit(arr[i], exp)]--;
        }
        System.arraycopy(sort, 0, arr, 0, len);
        printAll(sort, len);
    }

    public void printAll(int[] arr, int len) {
        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2137198, 1231272, 3123134, 1413453, 2364738};
        RadixSort rs = new RadixSort();
        rs.radixSort(arr, arr.length, 7);
    }
}