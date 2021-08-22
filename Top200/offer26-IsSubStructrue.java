package Top200;

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

        return subStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean subStructure(TreeNode node1, TreeNode node2) {
        // node2 和 node1 判断是否为 null 的先后顺序需要清楚，
        // node2 == null, node1 == null 或者 node1 != null 都是 true
        if (node2 == null) {
            return true;
        }

        if (node1 ==  null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return subStructure(node1.left, node2.left) && subStructure(node1.right, node2.right);       
    }
}