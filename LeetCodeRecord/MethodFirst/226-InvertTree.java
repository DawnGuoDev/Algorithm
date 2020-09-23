package MethodFirst;

import java.util.LinkedList;
import java.util.Queue;

class InvertTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.right != null) {
                queue.offer(curr.right);
            }

            if (curr.left != null) {
                queue.offer(curr.left);
            }
        }

        return root;
    }

    
}
