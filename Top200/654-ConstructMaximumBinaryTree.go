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

func constructMaximumBinaryTree(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}

	return constructRecur(nums, 0, len(nums)-1)
}

func constructRecur(nums []int, left, right int) *TreeNode {
	if left > right {
		return nil
	}

	index := left
	max := nums[left]
	for i := left + 1; i <= right; i++ {
		if nums[i] > max {
			index = i
			max = nums[i]
		}
	}

	root := &TreeNode{
		Val: nums[index],
	}

	root.Left = constructRecur(nums, left, index-1)
	root.Right = constructRecur(nums, index+1, right)

	return root
}
