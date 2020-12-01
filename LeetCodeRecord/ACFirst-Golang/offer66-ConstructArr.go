package main

func constructArr(a []int) []int {
	aLen := len(a)
	res := make([]int, aLen)
	if aLen == 0 {
		return res
	}

	multi1 := make([]int, aLen)
	multi2 := make([]int, aLen)
	multi1[0] = 1
	multi2[aLen-1] = 1

	for i := 1; i < aLen; i++ {
		multi1[i] = multi1[i-1] * a[i-1]
	}

	for i := aLen - 2; i >= 0; i-- {
		multi2[i] = multi2[i+1] * a[i+1]
	}

	for i := 0; i < aLen; i++ {
		res[i] = multi1[i] * multi2[i]
	}

	return res
}

func constructArr2(a []int) []int {
	aLen := len(a)
	res := make([]int, aLen)
	if aLen == 0 {
		return res
	}

	multi := make([]int, aLen)
	multi[aLen-1] = 1

	for i := aLen - 2; i >= 0; i-- {
		multi[i] = multi[i+1] * a[i+1]
	}

	temp := 1
	for i := 0; i < aLen; i++ {
		res[i] = multi[i] * temp
		temp *= a[i]
	}

	return res
}
