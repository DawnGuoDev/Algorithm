package Top200;

class oddEvenList {
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
        ListNode dummy = new ListNode(-1);
        ListNode listOdd = new ListNode(-1);
        ListNode listEven = new ListNode(-1);

        ListNode curr = head;
        ListNode currOne = listOdd;
        ListNode currTwo = listEven;
        
        boolean odd = true; 
        
        while (curr != null) {
            if (odd) {
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
            
            odd = !odd;
        }

        dummy.next = listOdd.next;
        currOne.next = listEven.next;

        return dummy.next;
    }
    
}
