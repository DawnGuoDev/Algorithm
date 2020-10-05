package MethodFirst;

class SortList {
    class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }
    }
   
    /**
     * 递归的方式暂时未调通
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return recurSort(head, null);        
    }

    public ListNode recurSort(ListNode head, ListNode tail) {
        if (head.next == tail) {
            return head;
        }

        if (head.next.next == tail) {
            if (head.val > head.next.val) {
                int temp = head.next.val;
                head.next.val = head.val;
                head.val = temp;
            }

            return head; 
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = recurSort(head, slow);
        ListNode right = recurSort(slow, tail);
        ListNode newHead = new ListNode(-1);
        ListNode currNode = newHead;
        newHead.next = null;        

        while (left != right && right != tail) {
            if (left.val > right.val) {
                currNode.next = right;
                right = right.next;
            } else {
                currNode.next = left;
                left = left.next;
            }

            currNode = currNode.next;
            currNode.next = null;
        }

        if (right != tail) {
            currNode.next = right;
        }
        
        if (left != right) {
            currNode.next = left;
            
            while (left.next != right) {
                left = left.next;
            }
            left.next = tail;
        }

        return newHead.next;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len ++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int size = 1; size < len; size *= 2) {

            curr = dummy.next;
            ListNode tail = dummy;

            while (curr != null) {
                ListNode left = curr;
                ListNode right = this.cut(left, size);
                curr = this.cut(right, size);
                tail.next = this.merge(left, right);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }

        return dummy.next;
    }
    
    public ListNode cut(ListNode head, int size) {
        if (head == null) {
            return null;
        }

        while (size != 1 && head.next != null) {
            head = head.next;
            size--;
        }

        ListNode next = head.next;
        head.next = null;

        return next;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        if (left != null) {
            curr.next = left;
        }

        if (right != null) {
            curr.next = right;
        }

        return head.next;
    }
}
