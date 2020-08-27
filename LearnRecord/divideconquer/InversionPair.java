package divideconquer;

import java.util.Arrays;

public class InversionPair {
    private int count = 0;
   
    public void mergeSortCount(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int middle = begin + ((end - begin) >> 1);

        mergeSortCount(a, begin, middle);
        mergeSortCount(a, middle + 1, end);

        merge(a, begin, middle, end);
    }

    public void merge(int[] a, int begin, int middle, int end) {
        int p = begin;
        int q = middle + 1;
        int k = 0;
        int[] temp = new int[end - begin + 1];
        
        while (p <= middle && q <= end) {
            if (a[p] <= a[q]) {
                temp[k++] = a[p++];
            } else {
                this.count += middle - p + 1;
                temp[k++] = a[q++];
            }
        }

        while (p <= middle) {
            temp[k++] = a[p++];
        }

        while (q <= end) {
            temp[k++] = a[q++];
        }
        
        System.arraycopy(temp, 0, a, begin, end - begin + 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 4, 3, 1, 2};
        InversionPair ip = new InversionPair();
        ip.mergeSortCount(a, 0, a.length - 1);

        System.out.println(ip.count);
        System.out.println(Arrays.toString(a));
    }
}