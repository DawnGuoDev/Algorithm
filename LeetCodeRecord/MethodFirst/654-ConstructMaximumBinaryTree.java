package MethodFirst;

class ConstructMaximumBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    public TreeNode recur(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIndex = -1;
        int max = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        TreeNode leftNode = recur(nums, left, maxIndex - 1);
        TreeNode rightNode = recur(nums, maxIndex + 1, right);

        TreeNode curr = new TreeNode(max);
        curr.left = leftNode;
        curr.right = rightNode;

        return curr;
    }
    
}
