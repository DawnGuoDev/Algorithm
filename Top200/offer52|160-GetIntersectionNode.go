package main

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

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	pHeadA := headA
	pHeadB := headB

	// 需要确保 pHeadA 和 pHeadB 每次循环只走一步，要不是接着原链表往一步，
	// 要不就是从新的链表开始
	for pHeadA != pHeadB {
		if pHeadA != nil {
			pHeadA = pHeadA.Next
		} else {
			pHeadA = headB
		}

		if pHeadB != nil {
			pHeadB = pHeadB.Next
		} else {
			pHeadB = headA
		}
	}

	return pHeadA
}

/*
// 需要确保 pHeadA 和 pHeadB 每次循环只走一步，要不是接着原链表往一步，要不就是从新的链表开始。
// 这种的实现方法错误在于，每次循环不一定只走一步了。
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    pHeadA := headA
	pHeadB := headB
	for pHeadA != pHeadB {
		pHeadA = pHeadA.Next
		pHeadB = pHeadB.Next

		if pHeadA == nil {
			pHeadA = headB
		}

		if pHeadB == nil {
			pHeadB = headA
		}
	}

	if pHeadA == nil {
		return nil
	}

	return pHeadA
}
*/
