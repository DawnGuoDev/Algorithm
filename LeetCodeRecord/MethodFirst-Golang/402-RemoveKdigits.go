package main

import "strings"

func removeKdigits(num string, k int) string {
	stack := []rune{}
	remain := len(num) - k

	for _, ch := range num {
		for k > 0 && len(stack) != 0 && ch < stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
			k--
		}
		stack = append(stack, ch)
	}
	stack = stack[:remain]

	ans := strings.TrimLeft(string(stack), "0")
	if ans == "" {
		ans = "0"
	}

	return ans
}
