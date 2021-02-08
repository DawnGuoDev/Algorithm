package main

func addDigits(num int) int {
	for num > 9 {
		sum := 0
		for num != 0 {
			sum += num % 10
			num = num / 10
		}

		num = sum
	}

	return num
}

func addDigits2(num int) int {
	if num == 0 {
		return 0
	}

	if num%9 == 0 {
		return 9
	}

	return num % 9
}
