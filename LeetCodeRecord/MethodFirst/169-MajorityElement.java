package MethodFirst;

class MajorityElement {
    public int majorityElement(int[] nums) {
        int x = 0; // 记录第一个数字
        int votes = 0; // 统计票数

        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }

            if (x == num) {
                votes ++;
            } else {
                votes --;
            }
        }

        return x;
    }    
}
