package main

import "sort"

type Ints []int

func (a Ints) Len() int {
	return len(a)
}

func (a Ints) Swap(i, j int) {
	a[i], a[j] = a[j], a[i]
}

func (a Ints) Less(i, j int) bool {
	return a[i] < a[j]
}

func combinationSum2(candidates []int, target int) [][]int {
	res := [][]int{}
	temp := []int{}

	sort.Sort(Ints(candidates))

	getCombination(0, candidates, 0, target, temp, &res)

	return res
}

func getCombination(index int, candidates []int, sum, target int, temp []int, res *[][]int) {
	for i := index; i < len(candidates); i++ {
		if i != index && candidates[i] == candidates[i-1] {
			continue
		}

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
			break
		}

		if sum+num < target {
			temp = append(temp, num)
			getCombination(i+1, candidates, sum+num, target, temp, res)
			temp = temp[:len(temp)-1]
		}
	}
}
