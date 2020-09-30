package MethodFirst;

import java.util.HashSet;
import java.util.Set;

class DeleteDuplicates {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 写这个题解的时候，没注意到是有序链表
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        Set<Integer> set = new HashSet<Integer>();

        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next; 
                curr = curr.next;
            } else {
                set.add(curr.val);
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                ListNode temp = curr.next;
                curr.next = curr.next.next;
                temp.next = null;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}
