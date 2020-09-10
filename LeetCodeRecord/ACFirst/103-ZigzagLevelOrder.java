package ACFirst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigzagLevelOrder {
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return res;         
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> level;
        queue.offer(root);
        boolean orderLeftToRight = true;

        while (!queue.isEmpty()) {
            level = new ArrayList<Integer>();            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (orderLeftToRight) {
                    level.add(curr.val);
                } else {
                    level.add(0, curr.val);
                }
                
                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                } 
            }

            orderLeftToRight = !orderLeftToRight;
            res.add(level);
        }

        return res;
    }    
    
    // DFS
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }

        levelDFS(res, 0, root);

        return res;
    }

    public void levelDFS(List<List<Integer>> res, int level, TreeNode node) {
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        
        if (level % 2 == 0) {
            res.get(level).add(node.val);    
        } else {
            res.get(level).add(0, node.val);
        }

        if (node.left != null) {
            levelDFS(res, level + 1, node.left);
        }

        if (node.right != null) {
            levelDFS(res, level + 1, node.right);
        }
    }
}
