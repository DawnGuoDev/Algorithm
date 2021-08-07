package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

func partition(head *ListNode, x int) *ListNode {
	l1 := &ListNode{Val: -1, Next: nil}
	l2 := &ListNode{Val: -1, Next: nil}
	l1Bak := l1
	l2Bak := l2
	nl := &ListNode{Val: -1, Next: nil}
	curr := head

	for curr != nil {
		if curr.Val < x {
			l1.Next = curr
			l1 = l1.Next
			curr = curr.Next
			l1.Next = nil
		} else {
			l2.Next = curr
			l2 = l2.Next
			curr = curr.Next
			l2.Next = nil
		}
	}

	l1.Next = l2Bak.Next
	nl.Next = l1Bak.Next

	return nl.Next
}
