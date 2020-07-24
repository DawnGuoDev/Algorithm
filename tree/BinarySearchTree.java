package tree;

/**
 * ToDo：考虑数据重复的情况
 */
public class BinarySearchTree {
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

    /**
     * 查找节点
     * @param data
     * @return
     */
    public Node findNode(int data) {
        Node p = this.tree;

        while (p != null) {
            if (p.data == data) {
                return p;
            } else if (p.data < data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }

    /**
     * 添加节点
     * @param data
     */
    public void addNode(int data) {
        if (this.tree == null) {
            this.tree = new Node(data);
            return;
        }

        Node p = this.tree;

        while (p != null) {
            if (p.data < data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }

                p = p.left;
            }
        }
    }

    /**
     * 删除节点
     * @param data
     */
    public void deleteNode(int data) {
        Node p = this.tree;
        Node pParent = null;    // p 的父节点

        while (p != null && p.data != data) {
            pParent = p;

            if (p.data < data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null) {
            return;
        }

        // 要删除的节点有左右子节点
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p; // minP 的父节点
            
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            
            p.data = minP.data; // 将 minP 的数据替换到 p 中 
            
            /* 技巧：对右子树中最小的节点进行删除，
               这种情况跟要删除的节点只有一颗子树或者没有子树情况一样，
               所以这边将 minPP 赋值给 pParent，minP 赋值给 p，那么重复使用一段代码 */
            pParent = minPP;    
            p = minP;
        }

        Node child = null;
        // 要删除的节点只有左节点的情况
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {   // 要删除的节点只有右子节点的情况
            child = p.right;
        } else {    // 要删除的节点左右子节点都无的情况
            child = null;
        }

        // 删除的是根节点的情况
        if (pParent == null) {
            this.tree = child;
        }

        // 将 p 父节点的左/右子树重新指向
        if (pParent.left == p) {
            pParent.left = child;
        } else if (pParent.right == p){
            pParent.right = child;
        } 
    }

    /**
     * 找到二叉树查找树中的最小节点
     * 即一直左子节点下去
     * @return
     */
    public Node findMin() {
        Node p = this.tree;

        while (p != null && p.left != null) {
            p = p.left;
        }

        // 这个情况相当于树为空的情况
        if (p == null) {
            return null;
        }

        return p;
    }

    /**
     * 找到二叉查找树的最大节点
     * 即一直右子节点下去
     * @return
     */
    public Node findMax() {
        Node p = this.tree;

        while (p != null && p.right != null) {
            p = p.right;
        }

        if (p == null) {
            return null;
        }

        return p;
    }

    /**
     * 中序遍历来查看效果
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

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(5);
        bst.addNode(6);
        bst.addNode(1);
        bst.addNode(9);
        bst.addNode(4);
        bst.inOrder(bst.tree);
        System.out.println();

        Node p = bst.findNode(9);
        if (p != null) {
            System.out.println(p.data);
        } else {
            System.out.println("404");
        }
        

        System.out.println(bst.findMax().data);

        System.out.println(bst.findMin().data);

        bst.deleteNode(9);
        bst.inOrder(bst.tree);
        System.out.println();
    }
}