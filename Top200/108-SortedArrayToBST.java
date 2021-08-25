package Top200;

class SortedArrayToBST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
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

        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recur(nums, left, mid - 1);
        root.right = recur(nums, mid + 1, right);

        return root;
    }
    
}
