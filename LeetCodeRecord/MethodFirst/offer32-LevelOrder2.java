package MethodFirst;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();        

        if (root == null) {
            return res;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode temp = null;
            List<Integer> list = new ArrayList<Integer>();    

            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                list.add(temp.val);
                
                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }

            res.add(list);
        }

        return res;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        dfs(root, res, 0);

        return res;
    }

    public void dfs(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) {
            return;
        }

        if (depth >= res.size()) {
            res.add(new ArrayList<Integer>());
        }

        res.get(depth).add(root.val);

        /*
        if (depth % 2 == 0) {
            res.get(depth).add(root.val);
        } else {
            res.get(depth).add(0, root.val);
        }
        */

        dfs(root.left, res, depth + 1);
        dfs(root.right, res, depth + 1);
    }
}
