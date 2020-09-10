package ACFirst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LevelOrder {
    
    class TreeNode {
        int val; 
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // BFS 的方法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return res;
        }

        List<Integer> line;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            line = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null) {
                    queue.offer(curr.left);
                }

                if (curr.right != null) {
                    queue.offer(curr.right);
                }

                line.add(curr.val);
            }

            res.add(line);
        }

        return res;
    }

    // DFS 的方式
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (root == null) {
            return res;
        }
        
        levelDFS(res, 0, root);
        return res;
    }

    public void levelDFS(List<List<Integer>> res, int level, TreeNode node) {
        if (level >= res.size()) {
            res.add(new ArrayList<Integer>());
        }

        res.get(level).add(node.val);

        if (node.left != null) {
            levelDFS(res, level + 1, node.left);
        }

        if (node.right != null) {
            levelDFS(res, level + 1, node.right);
        }
    }
}
