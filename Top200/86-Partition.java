package Top200;

class Partition {
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

    public ListNode partition(ListNode head, int x) {
        ListNode listOne = new ListNode(-1);
        ListNode listTwo = new ListNode(-1);
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        ListNode currOne = listOne;
        ListNode currTwo = listTwo; 

        while (curr != null) {
            if (curr.val < x) {
                currOne.next = curr;
                curr = curr.next;
                currOne = currOne.next;
                currOne.next = null;
            } else {
                currTwo.next = curr;
                curr = curr.next;
                currTwo = currTwo.next;
                currTwo.next = null;
            }
        }

        currOne.next = listTwo.next;
        dummy.next = listOne.next;

        return dummy.next;
    }
}
