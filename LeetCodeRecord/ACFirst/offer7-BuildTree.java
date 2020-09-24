package ACFirst;

import java.util.HashMap;
import java.util.Map;

class BuildTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return recur(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public TreeNode recur(int[] preorder, int leftP, int rightP, int[] inorder, int leftI, int rightI, Map<Integer, Integer> map) {
        if (leftP > rightP) {
            return null;
        }

        int index = map.get(preorder[leftP]);
        TreeNode leftNode = recur(preorder, leftP + 1, (index - leftI) + leftP,  inorder, leftI, index - 1, map);
        TreeNode rightNode = recur(preorder, (index - leftI) + leftP + 1, rightP, inorder, index + 1, rightI, map);

        TreeNode curr = new TreeNode(preorder[leftP]);
        curr.left = leftNode;
        curr.right = rightNode;

        return curr;
    }    

}
