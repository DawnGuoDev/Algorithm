package Top200;

import java.util.ArrayList;
import java.util.List;

class ReversePrint {
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

    public int[] reversePrint(ListNode head) {
        List<Integer> resList = new ArrayList<Integer>();
         
        while (head != null) {
            resList.add(head.val);
            head = head.next;
        }

        int length = resList.size();
        int[] resArr = new int[length];   
        
        for (int i = length - 1, j = 0; i >= 0; i--, j++) {
            resArr[j] = resList.get(i);
        }

        return resArr;
    }

}
