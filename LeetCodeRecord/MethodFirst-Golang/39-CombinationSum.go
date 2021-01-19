package main

import "sort"

type Ints []int

func (a Ints) Len() int           { return len(a) }
func (a Ints) Swap(i, j int)      { a[i], a[j] = a[j], a[i] }
func (a Ints) Less(i, j int) bool { return a[i] < a[j] }

func combinationSum(candidates []int, target int) [][]int {
	res := [][]int{}
	temp := []int{}

	sort.Sort(Ints(candidates))

	getCombination(0, candidates, 0, target, temp, &res)

	return res
}

func getCombination(index int, candidates []int, sum, target int, temp []int, res *[][]int) {
	for i := index; i < len(candidates); i++ {
		num := candidates[i]
		if sum+num > target {
			break
		}

		if sum+num == target {
			temp = append(temp, num)
			tt := make([]int, len(temp))
			copy(tt, temp)
			*res = append(*res, tt)
			temp = temp[:len(temp)-1]
			continue
		}

		if sum+num < target {
			temp = append(temp, num)
			getCombination(i, candidates, sum+num, target, temp, res)
			temp = temp[:len(temp)-1]
		}
	}
}

func combinationSum2(candidates []int, target int) [][]int {
	res := [][]int{}
	temp := []int{}

	//sort.Sort(Ints(candidates))

	getCombination2(0, candidates, 0, target, temp, &res)

	return res
}

func getCombination2(index int, candidates []int, sum, target int, temp []int, res *[][]int) {
	for i := index; i < len(candidates); i++ {
		num := candidates[i]
		if sum+num > target {
			continue
		}

		if sum+num == target {
			temp = append(temp, num)
			tt := make([]int, len(temp))
			copy(tt, temp)
			*res = append(*res, tt)
			temp = temp[:len(temp)-1]
			continue
		}

		if sum+num < target {
			temp = append(temp, num)
			getCombination2(i, candidates, sum+num, target, temp, res)
			temp = temp[:len(temp)-1]
		}
	}
}
