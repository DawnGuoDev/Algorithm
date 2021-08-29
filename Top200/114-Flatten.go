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

func flatten(root *TreeNode) {
	if root == nil {
		return
	}
	var prev *TreeNode = nil

	flattenRecur(root, &prev)
}

func flattenRecur(root *TreeNode, prev **TreeNode) {
	if root == nil {
		return
	}

	flattenRecur(root.Right, prev)
	flattenRecur(root.Left, prev)

	root.Right = *prev
	root.Left = nil

	*prev = root
}

func flatten2(root *TreeNode) {
	if root == nil {
		return
	}

	flattenRecur2(root)
}

func flattenRecur2(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	right := flattenRecur2(root.Right)
	left := flattenRecur2(root.Left)

	if left == nil {
		root.Right = right
		return root
	}

	curr := left

	for curr.Right != nil {
		curr = curr.Right
	}

	curr.Right = right

	root.Right = left
	root.Left = nil

	return root
}

func flattenRecur3(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	left := flattenRecur3(root.Left)
	right := flattenRecur3(root.Right)

	if left == nil {
		root.Right = right
		return root
	}

	curr := left

	for curr.Right != nil {
		curr = curr.Right
	}

	curr.Right = right

	root.Right = left
	root.Left = nil

	return root
}
