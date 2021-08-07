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

func reorderList(head *ListNode) {
	dummy := &ListNode{Val: -1}
	dummy.Next = head
	slow := dummy
	fast := dummy

	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	afterHead := reverseList(slow.Next)
	slow.Next = nil

	curr := head
	for afterHead != nil {
		temp := afterHead.Next
		afterHead.Next = curr.Next
		curr.Next = afterHead
		afterHead = temp
		curr = curr.Next.Next
	}
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode = nil
	curr := head

	for curr != nil {
		temp := curr.Next
		curr.Next = prev
		prev = curr
		curr = temp
	}

	return prev
}
