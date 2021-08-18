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

type Stack struct {
	arr  []*TreeNode
	size int
}

func NewStack() *Stack {
	return &Stack{
		arr:  []*TreeNode{},
		size: 0,
	}
}

func (s *Stack) Pop() *TreeNode {
	if s.size <= 0 {
		return nil
	}

	tNode := s.arr[s.size-1]
	s.arr = s.arr[:s.size-1]
	s.size--

	return tNode
}

func (s *Stack) Push(node *TreeNode) {
	s.arr = append(s.arr, node)
	s.size++
}

func (s *Stack) IsEmpty() bool {
	if s.size == 0 {
		return true
	}

	return false
}

func preorderTraversal(root *TreeNode) []int {
	res := []int{}
	preorder(root, &res)

	return res
}

func preorder(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}

	*res = append(*res, root.Val)

	preorder(root.Left, res)

	preorder(root.Right, res)
}

func preorderTraversal2(root *TreeNode) []int {
	res := []int{}
	stack := NewStack()

	if root == nil {
		return res
	}

	stack.Push(root)

	for !stack.IsEmpty() {
		node := stack.Pop()

		res = append(res, node.Val)

		if node.Right != nil {
			stack.Push(node.Right)
		}

		if node.Left != nil {
			stack.Push(node.Left)
		}
	}

	return res
}
