package main

func hammingDistance(x, y int) int {
	count := 0

	for i := 0; i < 32; i++ {
		if (x%2 == 1 && y%2 == 0) || (x%2 == 0 && y%2 == 1) {
			count++
		}
		x = x / 2
		y = y / 2
	}

	return count
}

func hammingDistance2(x, y int) int {
	xor := x ^ y // x 和 y 异或之后不同的位就会变为 1，所以统计 1 的个数就好
	count := 0

	for xor != 0 {
		xor = xor & (xor - 1)
		count++
	}

	return count
}
