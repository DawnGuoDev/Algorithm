package ACFirst;

import java.util.LinkedList;
import java.util.Queue;

class MaxDepath {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root  == null) {
            return 0;
        }
        
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            max ++;
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }    

                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }

        return max; 
    }    

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);

        return Math.max(left, right) + 1;
    }
}
