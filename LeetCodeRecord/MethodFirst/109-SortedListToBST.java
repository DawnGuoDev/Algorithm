package MethodFirst;

class SortedListToBST {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public ListNode currNode = null;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        this.currNode = head;
        int len = this.getLength(head);
        
        return recur(0, len - 1);
    }

    public TreeNode recur(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = ((right - left) >> 1) + left;

        TreeNode leftNode = recur(left, mid - 1);

        TreeNode curr = new TreeNode(currNode.val);
        currNode = currNode.next;

        TreeNode rightNode = recur(mid + 1, right);

        curr.left = leftNode;
        curr.right = rightNode;
        
        return curr;
    }

    public int getLength(ListNode head) {
        int count = 0;
        
        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    public TreeNode sortedListToBST2(ListNode node) {
        if (node == null) {
            return null;
        }

        return recur2(node, null);
    }

    public TreeNode recur2(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode mid = getMidNode(left, right);
        TreeNode leftNode = recur2(left, mid);
        TreeNode rightNode = recur2(mid.next, right);

        TreeNode curr = new TreeNode(mid.val);
        curr.left = leftNode;
        curr.right = rightNode;

        return curr;
    }

    public ListNode getMidNode(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;

        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
