package main

func singleNumber(nums []int) int {
	bits := make([]int, 64)

	for _, num := range nums {
		for j := 0; j < 64; j++ {
			bits[j] += (num & 1)
			num >>= 1
		}
	}

	for i := 0; i < 64; i++ {
		bits[i] = bits[i] % 3
	}

	res := 0
	for i := 63; i >= 0; i-- {
		res = res << 1
		res |= bits[i]
	}

	return res
}
