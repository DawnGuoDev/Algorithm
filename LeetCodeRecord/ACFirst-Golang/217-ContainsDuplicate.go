package main

func containsDuplicate(nums []int) bool {
	multi := make(map[int]bool)

	for _, num := range nums {
		if _, ok := multi[num]; ok {
			return true
		}
		multi[num] = true
	}

	return false
}
