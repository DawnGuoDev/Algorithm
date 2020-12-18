package main

func twoSum(nums []int, target int) []int {
	maps := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		if elem, ok := maps[target - nums[i]]; ok == true {
			return []int{elem, i}			
		}

		maps[nums[i]] = i
	}
	
	return []int{}
}