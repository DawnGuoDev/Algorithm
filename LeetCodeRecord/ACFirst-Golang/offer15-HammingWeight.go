package main

func hammingWeight(num uint32) {
	res := 0

	for num != 0 {
		num &= (num - 1)
		res++
	}

	return res
}
