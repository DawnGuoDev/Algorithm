package main

import (
	"strconv"
	"strings"
)

func minNumber(nums []int) string {
	numStrs := make([]string, len(nums))
	for i := 0; i < len(nums); i++ {
		numStrs[i] = strconv.Itoa(nums[i])
	}

	quickSort(numStrs, 0, len(numStrs)-1)

	strRes := ""

	for _, str := range numStrs {
		strRes += str
	}

	return strRes
}

func quickSort(nums []string, left, right int) {
	if left >= right {
		return
	}

	pivot := nums[right]
	i := left
	j := left

	for j <= right {
		if strings.Compare(nums[j]+pivot, pivot+nums[j]) <= 0 {
			temp := nums[i]
			nums[i] = nums[j]
			nums[j] = temp
			i++
		}

		j++
	}

	quickSort(nums, left, i-2)
	quickSort(nums, i, right)
}
