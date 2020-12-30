package main

func isHappy(n int) bool {
	slow := n
	fast := n

	for fast != 1 {
		slow = doSum(slow)
		fast = doSum(fast)
		fast = doSum(fast)

		if slow == fast {
			break
		}
	}

	if fast == 1 {
		return true
	}

	return false
}

func doSum(n int) int {
	sum := 0
	for n != 0 {
		temp := n % 10
		sum += temp * temp
		n = n / 10
	}

	return sum
}

func isHappy2(n int) bool {
	nums := make(map[int]bool)
	nums[n] = true

	for n != 1 {
		n = doSum(n)
		if _, ok := nums[n]; ok {
			break
		}

		nums[n] = true
	}

	if n == 1 {
		return true
	}

	return false
}
