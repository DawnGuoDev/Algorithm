package ACSecond;

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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();

        TreeNode curr = root;
        TreeNode prev = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek();
                
                if (temp.right == null || temp.right == prev) {
                    stack.pop();
                    list.add(temp.val);
                    prev = temp;
                } else {
                    curr = temp.right;
                }
            }
        }
        
        return list;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode vNode = new TreeNode(-1);
        vNode.left = root;
        TreeNode curr = vNode;
        
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    TreeNode temp = curr.left;
                    List<Integer> list = new ArrayList<Integer>();
                    
                    while (temp != curr) {
                        list.add(0, temp.val);
                        temp = temp.right;    
                    }

                    res.addAll(list);
                    
                    prev.right = null;
                    curr = curr.right;
                }
            } else {
                curr = curr.right;
            }
        } 

        return res;
    }
    
}
