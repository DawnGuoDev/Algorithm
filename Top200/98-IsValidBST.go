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

func isValidBST(root *TreeNode) bool {
	if root == nil {
		return true
	}

	return verifyBST(root.Left, math.MinInt64, int64(root.Val)) && verifyBST(root.Right, int64(root.Val), math.MaxInt64)
}

func verifyBST(root *TreeNode, min, max int64) bool {
	if root == nil {
		return true
	}

	if int64(root.Val) <= min || int64(root.Val) >= max {
		return false
	}

	return verifyBST(root.Left, min, int64(root.Val)) && verifyBST(root.Right, int64(root.Val), max)
}
