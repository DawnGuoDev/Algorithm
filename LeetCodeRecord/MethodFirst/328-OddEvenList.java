package MethodFirst;

class OddEvenList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddList = new ListNode(-1);
        ListNode evenList = new ListNode(-1);
        ListNode oddBak = oddList;
        ListNode evenBak = evenList;
        oddList.next = null;
        evenList.next = null;

        ListNode curr = head;
        boolean isOdd = true;

        while (curr != null) {
            if (isOdd) {
                oddList.next = curr;
                curr = curr.next;
                oddList.next.next = null;
                oddList = oddList.next;
            } else {
                evenList.next = curr;
                curr = curr.next;
                evenList.next.next = null;
                evenList = evenList.next; 
            }

            isOdd = !isOdd;
        }

        oddList.next = evenBak.next;

        return oddBak.next;
    }
    
}
