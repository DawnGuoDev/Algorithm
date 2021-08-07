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

func getKthFromEnd(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	// 快慢指针的思想
	fast := head
	for i := 0; i < k; i++ {
		fast = fast.Next
	}

	slow := head
	for fast != nil {
		slow = slow.Next
		fast = fast.Next
	}

	return slow
}
