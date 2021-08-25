package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type ListNode struct {
	Val  int
	Next *ListNode
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func sortedListToBST(head *ListNode) *TreeNode {
	if head == nil {
		return nil
	}

	return constructRecur(head, nil)
}

// head 取得到，tail 取不到
func constructRecur(head, tail *ListNode) *TreeNode {
	if head == tail {
		return nil
	}

	midListNode := getMidListNode(head, tail)
	root := &TreeNode{
		Val: midListNode.Val,
	}

	root.Left = constructRecur(head, midListNode)
	root.Right = constructRecur(midListNode.Next, tail)

	return root
}

func getMidListNode(head, tail *ListNode) *ListNode {
	slow := head
	fast := head

	for fast != tail && fast.Next != tail {
		slow = slow.Next
		fast = fast.Next
		fast = fast.Next
	}

	return slow
}
