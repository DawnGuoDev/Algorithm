package main

func permute(nums []int) [][]int {
	res := [][]int{}
	temp := []int{}
	visited := make([]bool, len(nums))

	getPermute(visited, nums, 0, len(nums), temp, &res)

	return res
}

func getPermute(visited []bool, nums []int, length, numsLen int, temp []int, res *[][]int) {
	if length == numsLen {
		tt := make([]int, numsLen)
		copy(tt, temp)
		*res = append(*res, tt)
		return
	}

	for i := 0; i < numsLen; i++ {
		if visited[i] {
			continue
		}
		temp = append(temp, nums[i])
		visited[i] = true
		getPermute(visited, nums, length+1, numsLen, temp, res)
		temp = temp[:len(temp)-1]
		visited[i] = false
	}
}
