package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	dummy := &ListNode{Val: -1}
	curr := dummy
	curr.Next = nil
	carry := 0

	for l1 != nil && l2 != nil {
		sum := l1.Val + l2.Val + carry
		carry = sum / 10
		sum = sum % 10

		curr.Next = &ListNode{Val: sum, Next: nil}
		curr = curr.Next

		l1 = l1.Next
		l2 = l2.Next
	}

	for l1 != nil {
		sum := l1.Val + carry
		carry = sum / 10
		sum = sum % 10

		curr.Next = &ListNode{Val: sum, Next: nil}
		curr = curr.Next

		l1 = l1.Next
	}

	for l2 != nil {
		sum := l2.Val + carry
		carry = sum / 10
		sum = sum % 10

		curr.Next = &ListNode{Val: sum, Next: nil}
		curr = curr.Next

		l2 = l2.Next
	}

	if carry != 0 {
		curr.Next = &ListNode{Val: carry, Next: nil}
	}

	return dummy.Next
}
