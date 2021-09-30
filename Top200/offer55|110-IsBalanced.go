package main

import "math"

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

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}

	_, b := balance(root)

	return b
}

func balance(root *TreeNode) (int, bool) {
	if root == nil {
		return 0, true
	}

	lDep, lBalance := balance(root.Left)
	rDep, rBalance := balance(root.Right)

	return (int)(math.Max((float64)(lDep), (float64)(rDep))) + 1, (math.Abs((float64)(lDep-rDep)) <= 1) && lBalance && rBalance
}

func isBalanced2(root *TreeNode) bool {
	if recur(root) == -1 {
		return false
	}

	return true
}

func recur(root *TreeNode) int {
	if root == nil {
		return 0
	}

	left := recur(root.Left)
	if left == -1 {
		return -1
	}

	right := recur(root.Right)
	if right == -1 {
		return -1
	}

	if math.Abs((float64)(left-right)) > 1 {
		return -1
	}

	return (int)(math.Max((float64)(left), (float64)(right))) + 1
}
