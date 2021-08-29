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

func generateTrees(n int) []*TreeNode {
	if n == 0 {
		return []*TreeNode{nil}
	}

	mem := make([][]([]*TreeNode), n+1)
	for i := 0; i < n; i++ {
		mem[i] = make([]([]*TreeNode), n+1)
	}

	return generateRecur(1, n, mem)
}

func generateRecur(start, end int, mem [][]*TreeNode) []*TreeNode {
	if start > end {
		return []*TreeNode{nil}
	}

	if mem[start][end] != nil {
		return mem[start][end]
	}

	res := []*TreeNode{}
	for i := start; i <= end; i++ {
		left := generateRecur(start, i-1)
		right := generateRecur(i+1, end)

		for _, l := range left {
			for _, r := range right {
				root := &TreeNode{
					Val:   i,
					Left:  l,
					Right: r,
				}

				res = append(res, root)
			}
		}

		mem = append(mem, res)
	}

	return res
}

func generateTrees2(n int) []*TreeNode {
	if n == 0 {
		return []*TreeNode{nil}
	}

	mem := make([][]([]*TreeNode), n+1)
	for i := 0; i <= n; i++ {
		mem[i] = make([]([]*TreeNode), n+1)
	}

	return generateRecur2(1, n, mem)
}

func generateRecur2(start, end int, mem [][]([]*TreeNode)) []*TreeNode {
	if start > end {
		return []*TreeNode{nil}
	}

	if len(mem[start][end]) != 0 {
		return mem[start][end]
	}

	res := []*TreeNode{}
	for i := start; i <= end; i++ {
		left := generateRecur2(start, i-1, mem)
		right := generateRecur2(i+1, end, mem)

		for _, l := range left {
			for _, r := range right {
				root := &TreeNode{
					Val:   i,
					Left:  l,
					Right: r,
				}

				res = append(res, root)
			}
		}
	}

	mem[start][end] = res

	return res
}
