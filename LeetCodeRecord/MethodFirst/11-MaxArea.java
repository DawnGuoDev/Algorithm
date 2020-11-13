package MethodFirst;

class MaxArea {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;

        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, height[i] * (j - i));
                i++;
            } else {
                res = Math.max(res, height[j] * (j - i));
                j--;
            }
        }

        return res;
    } 
}
