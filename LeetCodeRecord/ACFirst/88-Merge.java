package ACFirst;

class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums_copy = new int[m];
        System.arraycopy(nums1, 0, nums_copy, 0, m);
        int p = 0;
        int p1 = 0;     // 指向 nums_copy
        int p2 = 0;     // 指向 nums2
        while ((p1 < m) && (p2 < n)) {  // 进行比较，把小的先放进去
            if (nums_copy[p1] < nums2[p2]) {
                nums1[p++] = nums_copy[p1++];
            } else {
                nums1[p++] = nums2[p2++];                
            }
        }
        
        if (p1 < m) {
            System.arraycopy(nums_copy, p1, nums1, p, m - p1);
        } else {
            System.arraycopy(nums2, p2, nums1, p, n - p2);
        }
        // while (p1 < m) {
        //     nums1[p++] = nums_copy[p1++];
        // }
        
        // while (p2 < n) {
        //     nums1[p++] = nums2[p2++];
        // }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        Merge s = new Merge();
        s.merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }
}

