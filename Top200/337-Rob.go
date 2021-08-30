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

func rob(root *TreeNode) int {
	if root == nil {
		return 0
	}

	res := robRecur(root)
	// 1 是取这个节点
	// 0 是不取这个节点
	if res[0] < res[1] {
		return res[1]
	}

	return res[0]
}

func robRecur(root *TreeNode) []int {
	if root == nil {
		return []int{0, 0}
	}

	left := robRecur(root.Left)
	right := robRecur(root.Right)

	res := []int{0, 0}

	res[0] = int(math.Max(float64(left[0]), float64(left[1])) + math.Max(float64(right[0]), float64(right[1])))
	res[1] = left[0] + right[0] + root.Val

	return res
}
