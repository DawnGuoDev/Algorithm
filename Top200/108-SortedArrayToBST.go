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

func sortedArrayToBST(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}

	return constructRecur(nums, 0, len(nums)-1)
}

func constructRecur(nums []int, left, right int) *TreeNode {
	if left > right {
		return nil
	}

	mid := left + ((right - left) >> 1)
	root := &TreeNode{
		Val: nums[mid],
	}

	root.Left = constructRecur(nums, left, mid-1)
	root.Right = constructRecur(nums, mid+1, right)

	return root
}
