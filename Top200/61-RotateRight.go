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

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	len := 0
	curr := head
	for curr != nil {
		len++
		curr = curr.Next
	}
	k = k % len

	fast := head
	for i := 0; i < k; i++ {
		fast = fast.Next
	}

	slow := head

	for fast.Next != nil {
		slow = slow.Next
		fast = fast.Next
	}

	fast.Next = head
	ret := slow.Next
	slow.Next = nil

	return ret
}
