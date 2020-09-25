package ACFirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class LowestCommonAncestor2 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }    

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode == null) {
            return rightNode;
        }

        if (rightNode == null) {
            return leftNode;
        }

        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
        List<TreeNode> visited = new ArrayList<TreeNode>();
        
        map.put(root.val, null);
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();

                if (temp.left != null) {
                    queue.offer(temp.left);
                    map.put(temp.left.val, temp);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                    map.put(temp.right.val, temp);
                }
            }
        }

        TreeNode node = p;
        while (node != null) {
            visited.add(node);
            node = map.get(node.val); 
        }

        node = q;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            node = map.get(node.val);
        }

        return null;
    }
}
