package main

func isOneBitCharacter(bits []int) bool {
	i := 0

	for i < len(bits)-1 {
		if bits[i] == 1 {
			i += 2
		} else {
			i++
		}
	}

	return i == len(bits)-1
}
