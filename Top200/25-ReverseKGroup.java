package Top200;

class ReverseKGroup {
    class ListNode {
        int val;
        ListNode next;

        ListNode (int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        if (k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;

        while (head != null) {
            ListNode tail = prev;

            for (int i = 0; i < k; i++) {
                tail = tail.next;

                if (tail == null) {
                    return dummy.next;
                }
            }

            ListNode tailNext = tail.next;
            tail.next = null;

            ListNode prevIn = null;
            ListNode currIn = head;
            while (currIn != null) {
                ListNode temp = currIn.next;
                currIn.next = prevIn;
                prevIn = currIn;
                currIn = temp;
            }

            prev.next = prevIn;
            head.next = tailNext;

            prev = head;
            head = tailNext;
        }

        return dummy.next;
    }
}
