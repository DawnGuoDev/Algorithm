package MethodFirst;

import java.util.HashMap;
import java.util.Map;

class IsBalanced {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }    

    public boolean isBalanced(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }

        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        } 

        return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }        

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return  Math.abs(left - right) < 2 && isBalanced2(root.left) && isBalanced2(root.right);
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left, right) + 1;
    }


    public boolean isBalanced3(TreeNode root) {
        if (root == null) {
            return true;
        }        

        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        int left = getDepth2(root.left, map);
        int right = getDepth2(root.right, map);

        return  Math.abs(left - right) < 2 && isBalanced3(root.left) && isBalanced3(root.right);
    }

    public int getDepth2(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int left = getDepth2(root.left, map);
        int right = getDepth2(root.right, map);

        int depth = Math.max(left, right) + 1;
        map.put(root, depth);

        return depth;
    }
}


