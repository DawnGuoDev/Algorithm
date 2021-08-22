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

type Queue struct {
	arr  []*TreeNode
	size int
}

func (q *Queue) Push(t *TreeNode) {
	q.arr = append(q.arr, t)
	q.size++
}

func (q *Queue) Pop() *TreeNode {
	if q.size <= 0 {
		return nil
	}

	res := q.arr[0]
	q.arr = q.arr[1:q.size]
	q.size--

	return res
}

func (q *Queue) IsEmpty() bool {
	if q.size <= 0 {
		return true
	}

	return false
}

func (q *Queue) Size() int {
	return q.size
}

func NewQueue() *Queue {
	return &Queue{
		arr:  []*TreeNode{},
		size: 0,
	}
}

func levelOrder(root *TreeNode) [][]int {
	queue := NewQueue()
	res := [][]int{}

	if root == nil {
		return res
	}

	queue.Push(root)

	for !queue.IsEmpty() {
		size := queue.Size()
		tmp := []int{}

		for i := 0; i < size; i++ {
			node := queue.Pop()

			if node.Left != nil {
				queue.Push(node.Left)
			}

			if node.Right != nil {
				queue.Push(node.Right)
			}

			tmp = append(tmp, node.Val)
		}

		res = append(res, tmp)
	}

	return res
}
