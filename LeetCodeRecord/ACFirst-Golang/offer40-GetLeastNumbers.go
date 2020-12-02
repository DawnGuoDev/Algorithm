package main

func getLeastNumbers(arr []int, k int) []int {
	arrLen := len(arr)

	if arrLen == 0 || arrLen < k {
		return []int{}
	}
	
	if arrLen == k {
		return arr
	}

	res := make([]int, k)
	quickPick(arr, 0, len(arr) - 1, k)

	for i := 0; i < k; i++ {
		res[i] = arr[i]
	}

	return res
}

func quickPick(arr []int, left, right, k int) {
	if left >= right {
		return
	}

	i := left
	j := left
	pivotValue := arr[right]

	for  j <= right {
		if arr[j] <= pivotValue {
			temp := arr[i]
			arr[i] = arr[j]
			arr[j] = temp
			i++
		}
		j++
	}

	if (i - 1) == k {
		return
	}

	quickPick(arr, left, i - 2, k)
	quickPick(arr, i, right, k)
}
