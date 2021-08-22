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

func isSubStructure(A *TreeNode, B *TreeNode) bool {
	if B == nil {
		return false
	}

	if A == nil {
		return false
	}

	return subStructure(A, B) || isSubStructure(A.Left, B) || isSubStructure(A.Right, B)
}

func subStructure(A, B *TreeNode) bool {
	if B == nil {
		return true
	}

	if A == nil {
		return false
	}

	if A.Val != B.Val {
		return false
	}

	return subStructure(A.Left, B.Left) && subStructure(A.Right, B.Right)
}
