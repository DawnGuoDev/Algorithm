package main

func verifyPostorder(postorder []int) bool {
	return verify(postorder, 0, len(postorder)-1)
}

func verify(postorder []int, left, right int) bool {
	if left >= right {
		return true
	}

	index := left
	for index < right {
		if postorder[index] > postorder[right] {
			break
		}
		index++
	}

	mid := index
	for index < right {
		if postorder[index] < postorder[right] {
			return false
		}
		index++
	}

	return verify(postorder, left, mid-1) && verify(postorder, mid, right-1)
}
