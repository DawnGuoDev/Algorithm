package main

import "math"

func nthSuperUglyNumber(n int, primes []int) int {
	dp := make([]int, n)
	index := make([]int, len(primes))
	primesLen := len(primes)

	dp[0] = 1

	for i := 1; i < n; i++ {
		min := math.MaxInt64
		for j := 0; j < primesLen; j++ {
			multi := primes[j] * dp[index[j]]
			if multi < min {
				min = multi
				dp[i] = min
			}
		}

		for j := 0; j < primesLen; j++ {
			if min == primes[j]*dp[index[j]] {
				index[j]++
			}
		}
	}

	return dp[n-1]
}
