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

func reverseKGroup(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	if k == 1 {
		return head
	}

	// 主要思路就是：
	// 1. 先找到 k 个节点的区间，然后对这个区间内的链表进行翻转；
	// 2. 按照这种方式完成整个链表的翻转
	dummy := &ListNode{Val: -1}
	prev := dummy
	prev.Next = head

	for head != nil {
		// 先找到 k 个节点的区间
		tail := prev
		for i := 0; i < k; i++ {
			tail = tail.Next

			if tail == nil {
				return dummy.Next
			}
		}

		tailNext := tail.Next
		tail.Next = nil

		var prevIn *ListNode = nil
		var currIn *ListNode = head

		for currIn != nil {
			temp := currIn.Next
			currIn.Next = prevIn
			prevIn = currIn
			currIn = temp
		}

		prev.Next.Next = tailNext
		prev.Next = tail

		prev = head
		head = tailNext
	}

	return dummy.Next
}
