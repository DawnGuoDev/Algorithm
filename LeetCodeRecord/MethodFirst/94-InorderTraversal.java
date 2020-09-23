package MethodFirst;

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
        inorderRecur(root, res);
        
        return res;
    }

    public void inorderRecur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        inorderRecur(root.left, res);

        res.add(root.val);

        inorderRecur(root.right, res);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                // stack 中存的是本身和右子树没有访问过的
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                curr = temp.right;
            } 
        }

        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;

                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right != null) {
                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                } else {
                    pre.right = curr;
                    curr = curr.left;
                }
            } else {
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }
}
