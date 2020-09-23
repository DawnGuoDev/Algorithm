package MethodFirst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return list;
        }
        
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == size - 1) {
                    list.add(temp.val);
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }

        }

        return list;
    }


    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        dfs(root, res, 0);

        return res;
    }

    public void dfs(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return;
        }

        if (res.size() <= depth) {
            res.add(root.val);
        }

        dfs(root.right, res, depth + 1);
        dfs(root.left, res, depth + 1);
    }
    
}
