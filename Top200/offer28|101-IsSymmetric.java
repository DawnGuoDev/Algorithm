package Top200;

import java.util.LinkedList;
import java.util.Queue;

class IsSymmetric {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return symmetric(node1.left, node2.right) && symmetric(node1.right, node2.left);
    }
    
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode imageRoot = root;
        queue.offer(root);
        queue.offer(imageRoot);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) {
                continue;
            } 

            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }

}
