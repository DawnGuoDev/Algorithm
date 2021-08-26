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

func kthLargest(root *TreeNode, k int) int {
	var res int = 0

	dfs(root, &res, &k)

	return res
}

func dfs(root *TreeNode, res, k *int) {
	if root == nil {
		return
	}

	dfs(root.Right, res, k)

	if *k == 0 {
		return
	}

	*k = *k - 1
	if *k == 0 {
		*res = root.Val
		return
	}

	dfs(root.Left, res, k)
}
