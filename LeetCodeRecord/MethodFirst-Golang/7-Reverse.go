package main

import "math"

func reverse(x int) int {

	sum := 0
	for x != 0 {
		temp := x % 10
		x = x / 10
		sum = sum*10 + temp
	}

	if sum > math.MaxInt32 || sum < math.MinInt32 {
		return 0
	}
	return sum
}
