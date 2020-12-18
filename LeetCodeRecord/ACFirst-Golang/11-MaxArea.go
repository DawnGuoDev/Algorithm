package main

func maxArea(height []int) int {
	left := 0
	right := len(height) - 1
	area := 0

	for left < right {
		tempArea := 0
		if height[left] < height[right] {
			tempArea = (right - left) * height[left]
			left ++	
		} else {
			tempArea = (right - left) * height[right]
			right -- 
		}

		if tempArea > area {
			area = tempArea
		}
	}

	return area
}