package main

func partitionLabels(S string) []int {
	indexMap := make([]int, 26)

	for i := 0; i < 26; i++ {
		indexMap[i] = -1
	}

	for index, ch := range S {
		indexMap[ch-'a'] = index
	}

	ans := []int{}
	for i, start, end := 0, 0, 0; i < len(S); i++ {
		tmp := indexMap[int(S[i]-'a')]
		if tmp > end {
			end = tmp
		}

		if i == end {
			ans = append(ans, end-start+1)
			start = end + 1
		}
	}

	return ans
}
