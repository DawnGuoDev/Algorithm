package MethodFirst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        preRecur(root, res);

        return res;
    }

    public void preRecur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);

        preRecur(root.left, res);
        
        preRecur(root.right, res);
    }
    
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                curr = temp.right;
            }         
        }

        return res;
    }


    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;

                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right != null) {
                    curr = curr.right;
                    pre.right = null;
                } else {
                    pre.right = curr;
                    res.add(curr.val);
                    curr =  curr.left;

                }

            } else {
                res.add(curr.val);
                curr = curr.right;
            }
        }
        
        return res;
    }
}