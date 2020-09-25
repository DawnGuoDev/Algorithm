package MethodFirst;

import java.util.LinkedList;
import java.util.Queue;

class IsSymmetric {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }
    
    public boolean isSymmetric(TreeNode root) {
        return recur(root, root);
    }

    public boolean recur(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }


        return recur(root1.left, root2.right) && recur(root1.right, root2.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode rootImage = root;

        queue.offer(root);
        queue.offer(rootImage);

        while (!queue.isEmpty()) {
            TreeNode temp1 = queue.poll();
            TreeNode temp2 = queue.poll();

            if (temp1 == null && temp2 == null) {
                continue;
            }

            if (temp1 == null || temp2 == null || temp1.val != temp2.val) {
                return false;
            }

            queue.offer(temp1.left);
            queue.offer(temp2.right);

            queue.offer(temp1.right);
            queue.offer(temp2.left);
        }
        
        return true;
    }


}
