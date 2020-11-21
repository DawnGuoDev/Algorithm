package main

import (
	"sort"
)

type NewInt [][]int

func (data NewInt) Len() int {
	return len(data)
}

func (data NewInt) Swap(i, j int) {
	data[i], data[j] = data[j], data[i]
}

func (data NewInt) Less(i, j int) bool {
	return data[i][0] < data[j][0]
}

func merge(intervals [][]int) [][]int {
	sort.Sort(NewInt(intervals))
	res := [][]int{}

	for i, interval := range intervals {
		left := interval[0]
		right := interval[1]

		if i == 0 || left > res[len(res)-1][1] {
			res = append(res, interval)
		} else if left <= res[len(res)-1][1] {
			res[len(res)-1][1] = max(right, res[len(res)-1][1])
		}
	}

	return res
}

func max(i, j int) int {
	if i > j {
		return i
	}

	return j
}
