package MethodFirst;

class SortedArrayToBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    public TreeNode recur(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = ((right - left) >> 1) + left;
        TreeNode leftNode = recur(nums, left, mid - 1);
        TreeNode rightNode = recur(nums, mid + 1, right);

        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = leftNode;
        curr.right = rightNode;

        return curr;
    }
}