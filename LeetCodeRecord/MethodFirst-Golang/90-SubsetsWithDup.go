package main

import "sort"

type Ints []int

func (a Ints) Len() int           { return len(a) }
func (a Ints) Swap(i, j int)      { a[i], a[j] = a[j], a[i] }
func (a Ints) Less(i, j int) bool { return a[i] < a[j] }

func subsetsWithDup(nums []int) [][]int {
	res := [][]int{}
	temp := []int{}

	sort.Sort(Ints(nums))
	//fmt.Println(nums)
	getSets(0, nums, temp, &res)

	return res
}

func getSets(index int, nums []int, temp []int, res *[][]int) {
	*res = append(*res, temp)
	for i := index; i < len(nums); i++ {
		if i != index && nums[i] == nums[i-1] {
			continue
		}
		temp = append(temp, nums[i])
		tt := make([]int, len(temp))
		copy(tt, temp)
		getSets(i+1, nums, tt, res)
		temp = temp[:len(temp)-1]
	}
}
