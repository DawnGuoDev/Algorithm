package ACFirst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                res.add(node.val);
                curr = node.right;
            }
        }

        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode curr = root;
        TreeNode pre = null;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return res;
    }
}