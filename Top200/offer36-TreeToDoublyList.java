package Top200;

class TreeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre = null;
    Node head = null;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        
        dfs(root);

        pre.right = this.head;
        this.head.left = pre;
        return head;
    }
    
    public void dfs(Node root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        if (this.pre == null) {
            this.head = root;
        } else {
            this.pre.right = root;
        }
        
        root.left = this.pre; 
        this.pre = root;

        dfs(root.right);
    }
}
