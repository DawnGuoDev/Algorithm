package MethodFirst;

class IsSubStructure {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return subRecur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean subRecur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return subRecur(A.left, B.left) && subRecur(A.right, B.right);
    }
    
}
