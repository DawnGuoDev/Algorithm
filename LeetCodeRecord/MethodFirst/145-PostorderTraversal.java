package MethodFirst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PostorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        postorderRecur(root, res);
        
        return res;
    }

    public void postorderRecur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        postorderRecur(root.left, res);
        postorderRecur(root.right, res);

        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode pre = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek();

                if (temp.right == null || temp.right == pre) {
                    res.add(temp.val);
                    pre = stack.pop();   
                } else {
                    curr = temp.right;
            
                }
            }
        }
    
        return res;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode virNode =  new TreeNode(-1);
        virNode.left = root;
        root = virNode;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;

                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    TreeNode temp = curr.left;
                    List<Integer> tempList = new ArrayList<Integer>();
                    while (temp != null && temp != curr) {
                        tempList.add(0, temp.val);
                        temp = temp.right;
                    }

                    res.addAll(tempList);
                    pre.right = null;

                    curr = curr.right;
                }

            } else {
                curr = curr.right;
            }
        }

        return res;
    }
}
