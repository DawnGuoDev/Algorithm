package ACFirst;

import java.util.ArrayList;
import java.util.List;

class PreorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }    

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        getPre(root, res);
        return res;
    }

    public void getPre(TreeNode node, List<Integer> res) {
        res.add(node.val);

        if (node.left != null) {
            getPre(node.left, res);
        }

        if (node.right != null) {
            getPre(node.right, res);
        }
    }
}
