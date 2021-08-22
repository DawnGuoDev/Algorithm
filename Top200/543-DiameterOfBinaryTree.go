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

func diameterOfBinaryTree(root *TreeNode) int {
	if root == nil {
		return 0
	}

	_, dia := calcDiameter(root)

	return dia
}

func calcDiameter(root *TreeNode) (int, int) {
	if root == nil {
		return 0, 0
	}

	leftDep, leftDia := calcDiameter(root.Left)
	rightDep, rightDia := calcDiameter(root.Right)

	dia := leftDep + rightDep
	if leftDia > dia {
		dia = leftDia
	}
	if rightDia > dia {
		dia = rightDia
	}

	dep := leftDep
	if rightDep > dep {
		dep = rightDep
	}

	return dep + 1, dia
}
