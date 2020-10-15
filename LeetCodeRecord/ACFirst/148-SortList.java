package ACFirst;

class SortList {
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
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 先求链表的长度
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // 开始使用迭代的方式进行排序了
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (int size = 1; size < length; size *= 2) {
            ListNode tail = dummy;
            curr = dummy.next;

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
            return head;
        }

        while (size > 1 && head != null) {
            head = head.next;
            size--;
        }

        if (head == null) {
            return null;
        }

        ListNode ret = head.next;
        head.next = null;

        return ret;
    }

    public ListNode merge(ListNode listOne, ListNode listTwo) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        curr.next = null;

        while (listOne != null && listTwo != null) {
            if (listOne.val < listTwo.val) {
                curr.next = listOne;
                listOne = listOne.next;
            } else {
                curr.next = listTwo;
                listTwo = listTwo.next;
            }

            curr = curr.next;
            curr.next = null;
        }

        if (listOne != null) {
            curr.next = listOne;
        }

        if (listTwo != null) {
            curr.next = listTwo;
        }

        return dummy.next;
    }
}