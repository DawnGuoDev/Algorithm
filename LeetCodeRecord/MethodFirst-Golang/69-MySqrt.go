package main

import "math"

/**
时间复杂度为：O(n)
*/
func mySqrt(x int) int {
	if x == 0 || x == 1 {
		return x
	}

	for i := 1; i <= (x >> 1); i++ {
		if i*i <= x && (i+1)*(i+1) > x {
			return i
		}
	}

	return x
}

func mySqrt1(x int) int {
	left := 0
	right := x

	for left <= right {
		mid := left + ((right - left) >> 1)

		if mid*mid <= x && (mid+1)*(mid+1) > x {
			return mid
		}

		if mid*mid < x {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return left
}

func mySqrt2(x int) int {
	if x == 0 {
		return 0
	}

	C := float64(x)
	x0 := float64(x)

	for {
		xi := 0.5 * (x0 + (C / x0))
		if math.Abs(xi-x0) < 1e-6 {
			break
		}

		x0 = xi
	}

	return int(x0)
}
