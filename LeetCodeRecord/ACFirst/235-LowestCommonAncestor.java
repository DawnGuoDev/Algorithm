package ACFirst;

class LowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            if ((curr.val > p.val && curr.val < q.val) || (curr.val < p.val && curr.val > q.val)) {
                return curr;
            }
            
            if (curr.val == p.val || curr.val == q.val) {
                return curr;
            }

            if (curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            }

            if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            }
        }

        return null;
    }
   
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
            return root;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode res1 = lowestCommonAncestor2(root.left, p, q);
        TreeNode res2 =  lowestCommonAncestor2(root.right, p, q);

        if (res1 != null) {
            return res1;
        } else {
            return res2;
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            } else if (curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }

        return null;
    }
}
