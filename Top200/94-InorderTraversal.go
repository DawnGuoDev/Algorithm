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

	node := s.arr[s.size-1]
	s.arr = s.arr[:s.size-1]
	s.size--

	return node
}

func (s *Stack) Top() *TreeNode {
	if s.size <= 0 {
		return nil
	}

	return s.arr[s.size-1]
}

func (s *Stack) Push(node *TreeNode) {
	s.arr = append(s.arr, node)
	s.size++
}

func (s *Stack) IsEmpty() bool {
	if s.size <= 0 {
		return true
	}

	return false
}

func inorderTraversal(root *TreeNode) []int {
	res := []int{}

	inorder(root, &res)

	return res
}

func inorder(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}

	inorder(root.Left, res)

	*res = append(*res, root.Val)

	inorder(root.Right, res)
}

func inorderTraversal2(root *TreeNode) []int {
	res := []int{}
	stack := NewStack()

	if root == nil {
		return res
	}

	stack.Push(root)

	for !stack.IsEmpty() {
		node := stack.Top()

		if node.Left != nil {
			stack.Push(node.Left)
			node.Left = nil
			continue
		}

		res = append(res, node.Val)
		stack.Pop()

		if node.Right != nil {
			stack.Push(node.Right)
		}
	}

	return res
}
