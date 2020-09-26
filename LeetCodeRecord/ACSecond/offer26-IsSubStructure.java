package ACSecond;

class IsSubStructure {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        return rootStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean rootStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return rootStructure(A.left, B.left) && rootStructure(A.right, B.right);
    }
    
}
