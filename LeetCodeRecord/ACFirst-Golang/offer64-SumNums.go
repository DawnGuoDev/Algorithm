package main

func sumNums(n int) int {
	sum := 0
	pSum := &sum

	doSum(n, pSum)

	return sum
}

func doSum(n int, pSum *int) bool {
	temp := (n == 1 || doSum(n - 1, pSum))
	temp = temp

	*pSum = *pSum + n 

    return true
}