package MethodFirst;

class Partition {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode great = new ListNode(-1);
        ListNode greatBak = great;
        ListNode lessBak = less;
        less.next = null;
        great.next = null;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
                head = head.next;
                less.next = null;
            } else {
                great.next = head;
                great = great.next;
                head = head.next;
                great.next = null;
            }
        }

        less.next = greatBak.next; 

        return lessBak.next;
    } 
}
