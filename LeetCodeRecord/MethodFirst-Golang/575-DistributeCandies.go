package main

func distributeCandies(candyType []int) int {
	types := make(map[int]bool)

	for _, num := range candyType {
		if _, ok := types[num]; !ok {
			types[num] = true
		}
	}

	typeCount := len(types)

	if typeCount < (len(candyType) >> 1) {
		return typeCount
	} else {
		return len(candyType) >> 1
	}
}
