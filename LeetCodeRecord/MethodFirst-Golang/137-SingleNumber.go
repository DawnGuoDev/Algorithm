func singleNumber(nums []int) int {
	var count []int = make([]int, 64)

	for _, num := range nums {
		for i := 0; i < 64; i++ {
			count[i] +=  (num & 1)
			num >>= 1
		}
	}

	for i, value := range count {
		count[i] = value % 3
	}

	var resNum int = 0
	
	for i := 63; i >= 0; i-- {
		resNum <<= 1
		resNum |= count[i]
	}

	return resNum
}