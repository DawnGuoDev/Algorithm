package MethodFirst;

import java.util.ArrayList;
import java.util.List;

class ReversePrint {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<Integer>();
        
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        
        int size = res.size();
        int[] resArray = new int[size];
        for (int i = size - 1, j = 0; i >= 0; i--, j++) {
            resArray[j] = res.get(i);
        }
        
        return resArray;
    }


    public int[] reversePrint2(ListNode head) {
        List<Integer> res = new ArrayList<Integer>();

        recur(head, res);

        int size = res.size();
        int[] resArray = new int[size];
        for (int i = 0; i < size; i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }

    public void recur(ListNode head, List<Integer> res) {
        if (head == null) {
            return;
        }

        recur(head.next, res);

        res.add(head.val);
    }

    
}
