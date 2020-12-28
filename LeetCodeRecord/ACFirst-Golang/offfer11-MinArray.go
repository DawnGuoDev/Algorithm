package main

func minArray(numbers []int) int {
	left := 0
	right := len(numbers) - 1

	for left < right {
		mid := left + ((right - left) >> 1)

		if numbers[mid] < numbers[right] {
			right = mid
		} else if numbers[mid] > numbers[right] {
			left = mid + 1
		} else {
			index := left
			for i := left + 1; i < right; i++ {
				if numbers[i] < numbers[index] {
					index = i
				}
			}

			return numbers[index]
		}
	}

	return numbers[left]
}
