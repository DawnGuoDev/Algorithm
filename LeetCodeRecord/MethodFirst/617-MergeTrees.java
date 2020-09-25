package MethodFirst;

class MergeTrees {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 != null && t2 == null) {
            return t1;
        }

        if (t1 == null && t2 != null) {
            return t2;
        }

        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right=  mergeTrees(t1.right, t2.right);

        t1.val = t1.val + t2.val;
        t1.left = left;
        t1.right = right;

        return t1;
    }
}
