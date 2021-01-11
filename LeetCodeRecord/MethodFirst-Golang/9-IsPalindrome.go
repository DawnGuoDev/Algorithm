package main

func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}

	oldX := x
	newX := 0
	for x != 0 {
		temp := x % 10
		newX = newX*10 + temp
		x = x / 10
	}

	if newX == oldX {
		return true
	}

	return false
}
