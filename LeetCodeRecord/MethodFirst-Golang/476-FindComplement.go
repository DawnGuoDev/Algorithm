package main

func findComplement(num int) int {
	maxBitIndex := 0
	numCopy := num

	for i := 0; i < 32; i++ {
		if numCopy%2 == 1 {
			maxBitIndex = i + 1
		}
		numCopy /= 2
	}

	return ((1 << maxBitIndex) - 1) ^ num
}
