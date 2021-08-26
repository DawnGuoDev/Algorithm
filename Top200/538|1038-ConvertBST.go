package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func bstToGst(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	var sum int = 0
	gstRecur(root, &sum)

	return root
}

func gstRecur(root *TreeNode, sum *int) {
	if root == nil {
		return
	}

	gstRecur(root.Right, sum)

	*sum += root.Val
	root.Val = *sum

	gstRecur(root.Left, sum)
}
