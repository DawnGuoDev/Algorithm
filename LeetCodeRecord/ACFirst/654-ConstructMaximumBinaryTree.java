package ACFirst;


class ConstructMaximumBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
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

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int max = nums[left];
        int maxIdx = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        TreeNode curr = new TreeNode(max);
        curr.left = recur(nums, left, maxIdx - 1);
        curr.right = recur(nums, maxIdx + 1, right);

        return curr;
    } 
}
