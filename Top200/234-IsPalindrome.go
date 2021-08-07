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

func isPalindrome(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}

	dummy := &ListNode{Val: -1}
	slow := dummy
	fast := dummy
	dummy.Next = head

	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	reverseHead := reverseList(slow.Next)
	slow.Next = nil

	for reverseHead != nil {
		if head.Val != reverseHead.Val {
			return false
		}

		head = head.Next
		reverseHead = reverseHead.Next
	}

	return true
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
