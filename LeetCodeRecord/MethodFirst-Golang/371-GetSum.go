package main

func getSum(a, b int) int {
	for a != 0 {
		temp := ((a & b) << 1)
		b = a ^ b
		a = temp
	}

	return b
}
