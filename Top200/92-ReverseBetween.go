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

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	dummy := &ListNode{Val: -1}
	curr := dummy
	curr.Next = head

	for i := 1; i < left; i++ {
		curr = curr.Next
	}

	var prev *ListNode = nil
	tail := curr.Next

	for i := 0; i <= right-left; i++ {
		temp := tail.Next
		tail.Next = prev
		prev = tail
		tail = temp
	}

	curr.Next.Next = tail
	curr.Next = prev

	return dummy.Next
}

func reverseBetween2(head *ListNode, left int, right int) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	dummy := &ListNode{Val: -1}
	curr := dummy
	curr.Next = head

	for i := 1; i < left; i++ {
		curr = curr.Next
	}

	prev := curr
	curr = curr.Next

	for i := 0; i < right-left; i++ {
		tempNode1 := curr.Next.Next
		tempNode2 := curr.Next
		curr.Next.Next = prev.Next
		prev.Next = tempNode2
		curr.Next = tempNode1
	}

	return dummy.Next
}
