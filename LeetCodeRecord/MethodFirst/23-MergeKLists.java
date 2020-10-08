package MethodFirst;

import java.util.Comparator;
import java.util.PriorityQueue;

class MergeKLists {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0 || lists == null) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }

        });


        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        curr.next = null;
        
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            if (curr.next != null) {
                queue.offer(curr.next);
            }
        }
        
        return dummy.next;
    }    
}
