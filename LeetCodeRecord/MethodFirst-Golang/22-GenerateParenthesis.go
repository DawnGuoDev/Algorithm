package main

func generateParenthesis(n int) []string {
	res := []string{}

	if n == 0 {
		return res
	}

	dfs(&res, []rune{}, 0, 0, n)

	return res
}

func dfs(res *[]string, s []rune, left, right, max int) {
	if left == max && right == max {
		*res = append(*res, string(s))
	}

	if left < right {
		return
	}

	if left < max {
		s = append(s, '(')
		dfs(res, s, left+1, right, max)
		s = s[:left+right]
	}

	if right < max && left > right {
		s = append(s, ')')
		dfs(res, s, left, right+1, max)
		s = s[:left+right]
	}
}
