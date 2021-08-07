package main

import "container/heap"

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type ListNode struct {
	Val  int
	Next *ListNode
}

type ListNodeHeap []*ListNode

func (heap ListNodeHeap) Swap(i, j int) {
	heap[i], heap[j] = heap[j], heap[i]
}

func (heap ListNodeHeap) Less(i, j int) bool {
	return heap[i].Val < heap[j].Val
}

func (heap ListNodeHeap) Len() int {
	return len(heap)
}

func (heap *ListNodeHeap) Push(h interface{}) {
	*heap = append(*heap, h.(*ListNode))
}

func (heap *ListNodeHeap) Pop() interface{} {
	len := heap.Len()
	ret := (*heap)[len-1]
	*heap = (*heap)[:len-1]
	return ret
}

func mergeKLists(lists []*ListNode) *ListNode {
	hp := &ListNodeHeap{}
	heap.Init(hp)

	for _, l := range lists {
		if l != nil {
			heap.Push(hp, l)
		}
	}

	dummy := &ListNode{Val: -1}
	dummy.Next = nil
	curr := dummy

	for hp.Len() != 0 {
		ret := heap.Pop(hp).(*ListNode)
		curr.Next = ret
		curr = curr.Next
		if ret.Next != nil {
			heap.Push(hp, ret.Next)
		}
	}

	return dummy.Next
}
