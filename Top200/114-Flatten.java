package Top200;

import java.util.Stack;

class Flatten {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    // 类似莫里斯的方式
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;
                
                // 找到 curr.right 的前驱节点
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;

                curr = curr.right;
            } else {
                curr = curr.right;
            }
        }
    }

    public TreeNode pre = null;

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten2(root.right);
        flatten2(root.left);

        root.right = pre;
        root.left = null;

        pre = root;
    }

    public void flatten3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode pre = null;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }

                pre = curr;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
                
            } else {
                TreeNode temp = stack.pop();
                pre.right = temp;
                pre =  temp;
                curr = temp;
            }
        }
    }
}
