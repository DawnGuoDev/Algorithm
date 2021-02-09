package main

import (
	"sort"
	"strconv"
	"strings"
)

type Ints []int

func (data Ints) Less(i, j int) bool {
	str1 := strconv.Itoa(data[i]) + strconv.Itoa(data[j])
	str2 := strconv.Itoa(data[j]) + strconv.Itoa(data[i])

	num1, _ := strconv.Atoi(str1)
	num2, _ := strconv.Atoi(str2)

	if num1 < num2 {
		return false
	} else {
		return true
	}
}

func (data Ints) Swap(i, j int) {
	data[i], data[j] = data[j], data[i]
}

func (data Ints) Len() int {
	return len(data)
}

func largestNumber(nums []int) string {
	sort.Sort(Ints(nums))

	res := make([]string, len(nums))

	// 都是 0 的情况是细节处理，这种处理方式比较巧妙
	if nums[0] == 0 {
		return "0"
	}

	for i, num := range nums {
		res[i] = strconv.Itoa(num)
	}

	return strings.Join(res, "")
}
