package MethodFirst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PreInPostTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (root == null) {
            return res;
        }
        
        // 节点的右子树没有访问
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                res.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                curr = temp.right;
            }
        }

        return res;
    }
    
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        // 节点本身和右子树没有访问
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                curr = temp.right;
            }
        }
        
        return res;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        // 右子树和节点本身没有访问
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode last = null;   // 记录上一次访问的节点

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = stack.peek();

                if (temp.right == null || temp.right == last) {
                    res.add(temp.val);
                    last = stack.pop();
                } else {
                    curr = temp.right;
                }

            }
        } 
        
        return res;
    }

    public List<Integer> preOrderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (root == null) {
            return res;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    res.add(curr.val);
                    curr = curr.left;
                } else {
                    pre.right = null;
                    curr = curr.right;
                }
            } else {
                res.add(curr.val);
                curr = curr.right;
            }         
        }

        return res;
    }

    public List<Integer> inOrderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            } else {
                res.add(curr.val);
                curr = curr.right;
            }
        }

        return res;
    }

    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode virNode = new TreeNode(-1);
        virNode.left = root;
        root = virNode;
        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.left != null) {
                TreeNode pre = curr.left;

                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    TreeNode temp = curr.left;
                    List<Integer> listTemp = new ArrayList<Integer>();
                    while (temp != curr) {
                        listTemp.add(0, temp.val);
                        temp = temp.right;
                    }
                    res.addAll(listTemp);
                    

                    pre.right = null;
                    curr = curr.right;
                }

            } else {
                curr = curr.right;
            }

        }

        return res;
    }
}
