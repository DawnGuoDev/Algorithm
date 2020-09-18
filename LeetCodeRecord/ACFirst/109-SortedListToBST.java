package ACFirst;

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

    public TreeNode sortedListToBST(ListNode head) {
        return recur(head, null);
    }

    public TreeNode recur(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode mid = getMidListNode(head, tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = recur(head, mid);
        root.right = recur(mid.next, tail);

        return root;
    }

    public ListNode getMidListNode(ListNode head, ListNode tail) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != tail && fast.next != tail) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode currListNode;

    public TreeNode sortedListToBST2(ListNode head) {
        this.currListNode = head;
        int length = getListLength(head);
        
        return recurBuild(0, length - 1);
    }

    public TreeNode recurBuild(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = ((right - left) >> 1) + left;

        TreeNode leftNode = recurBuild(left, mid - 1);

        TreeNode root = new TreeNode(currListNode.val);
        currListNode = currListNode.next;

        TreeNode rightNode = recurBuild(mid + 1, right);

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

    public int getListLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length ++;
            head = head.next;
        }

        return length;
    }
}
