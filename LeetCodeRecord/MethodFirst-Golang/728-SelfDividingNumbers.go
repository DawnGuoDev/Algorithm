package main

func selfDividingNumbers(left int, right int) []int {
	res := []int{}

	for i := left; i <= right; i++ {
		if isSelfDividingNumber(i) {
			res = append(res, i)
		}
	}

	return res
}

func isSelfDividingNumber(num int) bool {
	var numCopy int = num

	for numCopy != 0 {
		temp := numCopy % 10
		if temp == 0 || num%temp != 0 {
			return false
		}
		numCopy /= 10
	}

	return true
}
