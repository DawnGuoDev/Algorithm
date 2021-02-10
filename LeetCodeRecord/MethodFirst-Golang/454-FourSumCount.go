package main

func fourSumCount(A, B, C, D []int) int {
	count := 0
	sumMap := make(map[int]int)

	// 分组 sum，再 hashmap
	for _, numA := range A {
		for _, numB := range B {
			tmpSum := numA + numB
			if value, ok := sumMap[tmpSum]; ok {
				sumMap[tmpSum] = value + 1
			} else {
				sumMap[tmpSum] = 1
			}
		}
	}

	for _, numC := range C {
		for _, numD := range D {
			tmpSum := numC + numD
			if value, ok := sumMap[-tmpSum]; ok {
				count += value
			}
		}
	}

	return count
}
