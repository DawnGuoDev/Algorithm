package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val   int
 *     Left  *TreeNode
 *     Right *TreeNode
 * }
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	if (root.Val > q.Val && root.Val < p.Val) || (root.Val < q.Val && root.Val > p.Val) {
		return root
	}

	if root.Val == q.Val || root.Val == p.Val {
		return root
	}

	res1 := lowestCommonAncestor(root.Left, p, q)
	res2 := lowestCommonAncestor(root.Right, p, q)

	if res1 != nil {
		return res1
	}

	return res2
}

func lowestCommonAncestor2(root, p, q *TreeNode) *TreeNode {
	curr := root

	for curr != nil {
		if (curr.Val > q.Val && curr.Val < p.Val) || (curr.Val < q.Val && curr.Val > p.Val) {
			return curr
		}

		if curr.Val == q.Val || curr.Val == p.Val {
			return curr
		}

		if curr.Val < q.Val && curr.Val < p.Val {
			curr = curr.Right
		}

		if curr.Val > q.Val && curr.Val > p.Val {
			curr = curr.Left
		}
	}

	return nil
}
