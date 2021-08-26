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

func kthSmallest(root *TreeNode, k int) int {
	var res int = 0
	dfs(root, &k, &res)

	return res
}

func dfs(root *TreeNode, k, res *int) {
	if root == nil {
		return
	}

	dfs(root.Left, k, res)

	if *k == 0 {
		return
	}

	*k = *k - 1
	if *k == 0 {
		*res = root.Val
		return
	}

	dfs(root.Right, k, res)
}
