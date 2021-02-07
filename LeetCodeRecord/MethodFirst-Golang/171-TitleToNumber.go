package main

func titleToNumber(s string) int {
	ans := 0
	for _, v := range s {
		ans = ans*26 + ((int)(v-'A') + 1)
	}

	return ans
}
