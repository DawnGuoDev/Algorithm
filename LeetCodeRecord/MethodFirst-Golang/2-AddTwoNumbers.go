package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{-1, l1}
	p1 := l1
	p2 := l2
	tail := l1
	carry := 0

	for p1 != nil && p2 != nil {
		sum := p1.Val + p2.Val + carry
		p1.Val = sum % 10
		carry = sum / 10

		tail = p1
		p1 = p1.Next
		p2 = p2.Next
	}

	for p1 != nil {
		sum := p1.Val + carry
		p1.Val = sum % 10
		carry = sum / 10

		tail = p1
		p1 = p1.Next
	}

	tail.Next = p2
	for p2 != nil {
		sum := p2.Val + carry
		p2.Val = sum % 10
		carry = sum / 10

		tail = p2
		p2 = p2.Next
	}

	if carry != 0 {
		newNode := &ListNode{carry, nil}
		tail.Next = newNode
	}

	return head.Next
}
