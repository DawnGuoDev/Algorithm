package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public Node tree;  //  树的根节点

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // 创建一个树（临时）
    public Node createTreeTemp() {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        
        return tree;
    }

    /**
     * 前序遍历
     * @param tree
     */
    public void preOrder(Node tree) {
        if (tree == null) {
            return;
        }
        
        System.out.print(tree.data + "  ");

        preOrder(tree.left);

        preOrder(tree.right);
    }

    /**
     * 中序遍历
     * @param tree
     */
    public void inOrder(Node tree) {
        if (tree == null) {
            return;
        }

        inOrder(tree.left);

        System.out.print(tree.data + "  ");

        inOrder(tree.right);
    }

    /**
     * 后序遍历
     * @param tree
     */
    public void postOrder(Node tree) {
        if (tree == null) {
            return;
        }

        postOrder(tree.left);

        postOrder(tree.right);

        System.out.print(tree.data + "  ");
    }

    /**
     * 层次遍历
     * @param tree
     */
    public void BFSOrder(Node tree) {
        if (tree == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Node temp = null;
        // 使用 offer 和 poll 优于 add 和 remove 之处在于前者可以通过返回值判断成功与否，而不抛出异常
        queue.offer(tree);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.data + "  ");
            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    /**
     * 求树的高度，从 1 开始
     * @param tree
     * @return
     */
    public int treeHeight (Node tree) {
        if (tree == null) {
            return 0;
        }

        int lHeight = treeHeight(tree.left);
        int rHeight = treeHeight(tree.right);

        return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.tree = bt.createTreeTemp();
        bt.preOrder(bt.tree);
        System.out.println();
        
        bt.inOrder(bt.tree);
        System.out.println();

        bt.postOrder(bt.tree);
        System.out.println();

        bt.BFSOrder(bt.tree);
        System.out.println();

        System.out.println(bt.treeHeight(bt.tree));
    }
    
}