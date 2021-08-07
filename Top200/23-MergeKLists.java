package Top200;

import java.util.Comparator;
import java.util.PriorityQueue;

class MergeKList {
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
        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1, null);
        ListNode curr = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        while (!queue.isEmpty()) {
            ListNode first = queue.poll();
            curr.next = first;
            curr = curr.next;
            if (curr.next != null) {
                queue.offer(curr.next);
            }
        }

        return dummy.next;
    }
}