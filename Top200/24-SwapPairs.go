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

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	dummy := &ListNode{Val: -1}
	prev := dummy
	prev.Next = head
	curr := head

	for curr != nil && curr.Next != nil {
		prev.Next = curr.Next
		curr.Next = prev.Next.Next
		prev.Next.Next = curr
		prev = curr
		curr = curr.Next
	}

	return dummy.Next
}

func swapPairs2(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	ret := swapPairs2(head.Next.Next)
	temp := head.Next

	head.Next.Next = head
	head.Next = ret

	return temp
}
