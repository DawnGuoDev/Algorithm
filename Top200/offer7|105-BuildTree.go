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

func buildTree(preorder []int, inorder []int) *TreeNode {
	if len(preorder) == 0 || len(inorder) == 0 {
		return nil
	}

	mInorder := make(map[int]int)
	for i := 0; i < len(inorder); i++ {
		mInorder[inorder[i]] = i
	}

	return buildRecur(preorder, 0, len(preorder)-1, inorder, 0, len(inorder)-1, mInorder)
}

func buildRecur(preorder []int, leftPre, rightPre int, inorder []int, leftIn, rightIn int, mInorder map[int]int) *TreeNode {
	if leftPre > rightPre {
		return nil
	}

	if leftPre == rightPre {
		return &TreeNode{
			Val:   preorder[leftPre],
			Left:  nil,
			Right: nil,
		}
	}

	root := &TreeNode{
		Val: preorder[leftPre],
	}

	index := mInorder[preorder[leftPre]]

	root.Left = buildRecur(preorder, leftPre+1, index-leftIn+leftPre, inorder, leftIn, index-1, mInorder)
	root.Right = buildRecur(preorder, index-leftIn+leftPre+1, rightPre, inorder, index+1, rightIn, mInorder)

	return root
}
