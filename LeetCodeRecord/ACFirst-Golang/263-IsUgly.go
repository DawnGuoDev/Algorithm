package main

func isUgly(num int) bool {
	if num == 0 {
		return false
	}

	for num%2 == 0 {
		num = num / 2
	}

	for num%3 == 0 {
		num = num / 3
	}

	for num%5 == 0 {
		num = num / 5
	}

	if num == 1 {
		return true
	}

	return false
}
