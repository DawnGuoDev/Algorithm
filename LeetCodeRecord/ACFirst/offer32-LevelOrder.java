package ACFirst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LevelOrder2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> resList = new ArrayList<Integer>();

        if (root == null) {
            return new int[0];
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            resList.add(curr.val);
            
            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }

        int size = resList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = resList.get(i);
        }

        return res;
    }
    
}
