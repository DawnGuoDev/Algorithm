package tree;

import java.util.LinkedList;

/**
 * 针对数据重复的情况进行处理
 */
public class BinarySearchTreePlus {
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
     * 查找出所有符合的节点
     * @param data
     * @return
     */
    public LinkedList<Node> findNode(int data) {
        Node p = this.tree;
        LinkedList<Node> ns = new LinkedList<>();

        while (p != null) {
            if (p.data == data) {
                ns.add(p);
                p = p.right;
            } else if (p.data < data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return ns;
    }

    /**
     * 添加节点，如果节点值相同则往右子树添加
     * @param data
     */
    public void addNode(int data) {
        if (this.tree == null) {
            this.tree = new Node(data);
            return;
        }

        Node p = this.tree;

        while (p != null) {
            if (p.data <= data) {
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
     * 删除所有符合的节点
     * @param data
     */
    public void deleteNode(int data) {
        Node p = this.tree;
        Node pParent = null;    // p 的父节点

        while (p != null) {
            if (p.data == data) {
                Node pRe = delete(pParent, p);
                p = pRe;
            } else if (p.data < data) {
                pParent = p;
                p = p.right;
            } else {
                pParent = p;
                p = p.left;
            }
        }
    }

    /**
     * 删除指定节点
     * @param pParent
     * @param p
     */
    public Node delete(Node pParent, Node p) {
        int flag = 0;
        Node pBak = p;

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
            
            flag = 1;
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

        /* 这边需要返回是因为假如删除只有一个子节点或没有子节点时，
           需要将 child 值，否则调用传入的 p 值将一直指向删除的节点；
           而需要返回不同的值是上述代码中，假如删除的是两个子节点的情况，
           那么 child 的值实际上不是真正需要删除的值，而是右子树中最小
           值对应的节点，这是不对。此时应该返回的是删除的节点，由于该节点
           的值进行了替换，所以返回原来的 p 值也可以（建议画图分析一下）*/
        return flag == 1 ? pBak : child;
    }

    /**
     * 中序遍历来查看树的情况
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
        BinarySearchTreePlus bst = new BinarySearchTreePlus();

        // bst.addNode(5);
        // bst.addNode(6);
        // bst.addNode(1);
        // bst.addNode(9);
        // bst.addNode(4);
        // bst.addNode(4);
        // bst.inOrder(bst.tree);
        // System.out.println();
        
        // LinkedList<Node> re = bst.findNode(4);
        // for (Node n : re) {
        //     System.out.print(n.data + " ");
        // }
        // System.out.println();

        // bst.deleteNode(4);
        // bst.inOrder(bst.tree);
        // System.out.println();

        bst.addNode(13);
        bst.addNode(8);
        bst.addNode(6);
        bst.addNode(10);
        bst.addNode(18);
        bst.addNode(16);
        bst.addNode(20);
        bst.addNode(18);
        bst.addNode(19);
        bst.inOrder(bst.tree);
        System.out.println();
        
        LinkedList<Node> re = bst.findNode(18);
        for (Node n : re) {
            System.out.print(n.data + " ");
        }
        System.out.println();

        bst.deleteNode(13);
        bst.inOrder(bst.tree);
        System.out.println();
    }
}