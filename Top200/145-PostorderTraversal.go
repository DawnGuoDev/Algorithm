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

func postorderTraversal(root *TreeNode) []int {
	res := []int{}

	postorder(root, &res)

	return res
}

func postorder(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}

	postorder(root.Left, res)
	postorder(root.Right, res)

	*res = append(*res, root.Val)
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

	res := s.arr[s.size-1]
	s.arr = s.arr[:s.size-1]
	s.size--

	return res
}

func (s *Stack) Push(t *TreeNode) {
	s.arr = append(s.arr, t)
	s.size++
}

func (s *Stack) Top() *TreeNode {
	if s.size <= 0 {
		return nil
	}

	return s.arr[s.size-1]
}

func (s *Stack) IsEmpty() bool {
	if s.size <= 0 {
		return true
	}

	return false
}

func postorderTraversal2(root *TreeNode) []int {
	stack := NewStack()
	res := []int{}
	curr := root
	var prev *TreeNode = nil

	for curr != nil || !stack.IsEmpty() {
		if curr != nil {
			stack.Push(curr)
			curr = curr.Left
		} else {
			tmp := stack.Top()

			if tmp.Right == nil || tmp.Right == prev {
				res = append(res, tmp.Val)
				prev = stack.Pop()
			} else {
				curr = tmp.Right
			}
		}
	}

	return res
}

// 这种方式会破坏树的结构
func postorderTraversal3(root *TreeNode) []int {
	stack := NewStack()
	res := []int{}

	if root == nil {
		return res
	}

	stack.Push(root)

	for !stack.IsEmpty() {
		tmp := stack.Top()

		if tmp.Left != nil {
			stack.Push(tmp.Left)
			tmp.Left = nil
			continue
		}

		if tmp.Right != nil {
			stack.Push(tmp.Right)
			tmp.Right = nil
			continue
		}

		stack.Pop()

		res = append(res, tmp.Val)
	}

	return res
}
