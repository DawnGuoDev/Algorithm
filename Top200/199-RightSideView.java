package Top200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class RightSideView {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {        
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode temp = null;

            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                
                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                
                if (i == size - 1) {
                    res.add(temp.val);
                }
            }
        }

        return res;
    }

    public int maxDepth = 0;
    public int currDepth = 0;
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        dfs(root, res);
        
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        ++ currDepth;
        if (currDepth > maxDepth) {
            maxDepth = currDepth;
            res.add(root.val);
        }

        dfs(root.right, res);
        dfs(root.left, res);

        currDepth --;
    }

    public List<Integer> rightSideView3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        dfs(root, res, 0);

        return res;
    }

    public void dfs(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return;
        }

        if (depth == res.size()) {
            res.add(root.val);
        }

        ++ depth;

        dfs(root.right, res, depth);
        dfs(root.left, res, depth);
    }
    
}
