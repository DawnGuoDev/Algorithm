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

func pathSum(root *TreeNode, target int) [][]int {
	res := [][]int{}

	if root == nil {
		return res
	}

	path := []int{}

	sumRecur(root, target, &res, path)

	return res
}

func sumRecur(root *TreeNode, sum int, res *[][]int, path []int) {
	if root == nil {
		return
	}

	path = append(path, root.Val)

	if root.Left == nil && root.Right == nil && sum-root.Val == 0 {
		tmp := make([]int, len(path))
		copy(tmp, path)
		*res = append(*res, tmp)
		return
	}

	sumRecur(root.Left, sum-root.Val, res, path)
	sumRecur(root.Right, sum-root.Val, res, path)

	path = (path)[:len(path)-1]
}
