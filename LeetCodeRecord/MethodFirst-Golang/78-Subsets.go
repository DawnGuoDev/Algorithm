package main

func subsets(nums []int) [][]int {
	res := [][]int{}
	temp := []int{}

	getSets(0, nums, temp, &res)

	return res
}

func getSets(index int, nums []int, temp []int, res *[][]int) {
	*res = append(*res, temp)
	for i := index; i < len(nums); i++ {
		temp = append(temp, nums[i])
		// fmt.Printf("1 %v, %p\n", temp, temp)
		// getSets(i+1, nums, temp, res)
		tt := make([]int, len(temp))
		copy(tt, temp)
		getSets(i+1, nums, tt, res)
		temp = temp[:len(temp)-1]
		// fmt.Printf("2 %v, %p\n", temp, temp)
	}
}
