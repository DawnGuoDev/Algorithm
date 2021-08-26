package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var (
	prev *TreeNode = nil
	head *TreeNode = nil
)

// 20210826: LeetCode 上没有 Go 语言这个选项
// 所以以下代码暂时未验证
func treeToDoublyList(root *TreeNode) *TreeNode {
	if root == nil {
		return nil
	}

	head.Left = prev
	prev.Right = head

	return head
}

func toDoublyList(root *TreeNode) {
	if root == nil {
		return
	}

	toDoublyList(root.Left)

	if prev == nil {
		head = root
	} else {
		prev.Right = root
	}

	root.Left = prev
	prev = root

	toDoublyList(root.Right)
}
