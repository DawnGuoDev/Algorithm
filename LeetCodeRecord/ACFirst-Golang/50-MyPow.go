package main

func myPow(x float64, n int) float64 {
	if n < 0 {
		n = -n
		x = 1 / x
	}

	if n == 0 {
		return 1
	}

	if n == 1 {
		return x
	}

	tempRes := myPow(x, n/2)
	tempRes = tempRes * tempRes

	if n%2 == 1 {
		tempRes = tempRes * x
	}

	return tempRes
}

func myPow2(x float64, n int) float64 {
	if n == 0 {
		return 1
	}

	if n < 0 {
		n = -n
		x = 1 / x
	}

	res := 1.0
	for n > 0 {
		if n%2 == 1 {
			res *= x
		}

		x = x * x

		n = n / 2
	}

	return res
}
