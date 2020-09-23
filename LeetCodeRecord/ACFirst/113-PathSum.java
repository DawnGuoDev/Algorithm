package ACFirst;

import java.util.ArrayList;
import java.util.List;

class PathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        recur(root, sum, res, list);

        return res;
    }

    public void recur(TreeNode root, int sum, List<List<Integer>> res, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        if (root.left == null && root.right == null && sum - root.val == 0) {
            List<Integer> temp = new ArrayList<Integer>(list);
            res.add(temp);
        }

        recur(root.left, sum - root.val, res, list);
        recur(root.right, sum - root.val, res, list);

        list.remove(list.size() - 1);
    }
}
