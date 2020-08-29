package ACFirst;

class Rob2 {
    public int rob(TreeNode root) {
        int[] re = robMax(root);

        return Math.max(re[0], re[1]);
    } 

    public int[] robMax(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int[] left = robMax(root.left);
        int[] right = robMax(root.right);

        int get = left[0] + right[0] + root.val;
        int noGet = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{noGet, get};
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
}