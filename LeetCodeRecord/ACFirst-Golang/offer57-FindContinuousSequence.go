package main

func findContinuousSequence(target int) [][]int {
	res := [][]int{}
	sum := 0

	for left, right := 1, 1; left <= target/2; {
		if sum < target {
			sum += right
			right++
		} else if sum > target {
			sum -= left
			left++
		} else {
			tempRes := []int{}
			for i := left; i < right; i++ {
				tempRes = append(tempRes, i)
			}

			res = append(res, tempRes)

			sum -= left
			left++

			sum += right
			right++
		}
	}

	return res
}
