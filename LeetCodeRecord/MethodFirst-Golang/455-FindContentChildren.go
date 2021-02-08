package main

import "sort"

type Ints []int

func (data Ints) Less(i, j int) bool {
	return data[i] < data[j]
}

func (data Ints) Len() int {
	return len(data)
}

func (data Ints) Swap(i, j int) {
	data[i], data[j] = data[j], data[i]
}

func findContentChildren(g []int, s []int) int {
	ans := 0
	sIndex := 0

	sort.Sort(Ints(g))
	sort.Sort(Ints(s))

	for _, v := range g {
		for ; sIndex < len(s); sIndex++ {
			if s[sIndex] >= v {
				ans++
				sIndex++
				break
			}
		}
	}

	return ans
}

func findContentChildren2(g []int, s []int) int {
	ans := 0
	sIndex := 0

	sort.Ints(g)
	sort.Ints(s)

	for _, v := range g {
		for ; sIndex < len(s); sIndex++ {
			if s[sIndex] >= v {
				ans++
				sIndex++
				break
			}
		}
	}

	return ans
}
