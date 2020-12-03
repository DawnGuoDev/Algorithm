package main

func singleNumbers(nums []int) []int {
	if len(nums) == 0 {
		return []int{}
	}

	xorAll := 0
	for _, num := range nums {
		xorAll ^= num
	}

	index := 1
	for index & xorAll == 0 {
		index = index << 1
	}
	
	num1 := 0
	num2 := 0
	for _, num := range nums {
		if num & index == 0 {
			num1 ^= num
		} else {
			num2 ^= num
		}
	}

	return []int{num1, num2}
}