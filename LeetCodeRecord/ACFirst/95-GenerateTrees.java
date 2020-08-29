package ACFirst;

import java.util.ArrayList;
import java.util.List;

class GenerateTrees {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> reList1 = generate(start, i - 1);
            List<TreeNode> reList2 = generate(i + 1, end);

            for (TreeNode node1 : reList1) {
                for (TreeNode node2 : reList2) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = node1;
                    newNode.right = node2;
                    list.add(newNode); 
                }
            }
        }

        return list;
    }

    /**
     * 加了缓存之后的方式
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        
        List<TreeNode>[][] mem = new ArrayList[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                mem[i][j] = null;
            }
        }

        return generate2(1, n, mem);
    }

    public List<TreeNode> generate2(int start, int end, List<TreeNode>[][] mem) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }

        if (mem[start][end] != null) {
            return mem[start][end];
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> reList1 = generate2(start, i - 1, mem);
            List<TreeNode> reList2 = generate2(i + 1, end, mem);

            for (TreeNode node1 : reList1) {
                for (TreeNode node2 : reList2) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = node1;
                    newNode.right = node2;
                    list.add(newNode); 
                }
            }
        }

        mem[start][end] = list;       
        return list;
    }
}