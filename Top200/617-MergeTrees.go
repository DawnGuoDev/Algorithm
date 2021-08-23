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

func mergeTrees(root1 *TreeNode, root2 *TreeNode) *TreeNode {
	if root1 == nil && root2 == nil {
		return nil
	}

	if root1 != nil && root2 == nil {
		return root1
	}

	if root1 == nil && root2 != nil {
		return root2
	}

	root1.Val = root1.Val + root2.Val

	left := mergeTrees(root1.Left, root2.Left)
	right := mergeTrees(root1.Right, root2.Right)

	root1.Left = left
	root1.Right = right

	return root1
}
