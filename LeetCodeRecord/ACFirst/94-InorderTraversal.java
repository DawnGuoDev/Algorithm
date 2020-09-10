package ACFirst;

import java.util.ArrayList;
import java.util.List;

class InorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        getInorder(root, res);
        
        return res;
    }

    public void getInorder(TreeNode node, List<Integer> res) {
        if (node.left != null) {
            getInorder(node.left, res);
        }

        res.add(node.val);

        if (node.right != null) {
            getInorder(node.right, res);
        }
    }
}