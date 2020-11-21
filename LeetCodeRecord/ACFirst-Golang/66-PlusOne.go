package main

func plusOne(digits []int) []int {
	res := []int{}
	carry := 1

	for i := len(digits) - 1; i >= 0; i-- {
		temp := carry + digits[i]

		carry = temp / 10
		digits[i] = temp % 10

		if carry == 0 {
			break
		}
	}

	if carry == 1 {
		res = append(res, 1)
		for i := 0; i < len(digits); i++ {
			res = append(res, digits[i])
		}

		return res
	}

	return digits
}
