package main

func sortColors(nums []int) {
	numsLen := len(nums)

	if numsLen == 0 {
		return
	}

	p0 := 0
	p1 := 0
	i := 0

	for i < numsLen {
		if nums[i] == 0 {
			temp := nums[i]
			nums[i] = nums[p1]
			nums[p1] = nums[p0]
			nums[p0] = temp

			p0++
			p1++
		} else if nums[i] == 1 {
			temp := nums[i]
			nums[i] = nums[p1]
			nums[p1] = temp
			p1++
		}

		i++
	}
}

func sortColors2(nums []int) {
	numsLen := len(nums)

	if numsLen == 0 {
		return
	}

	i := 0
	j := 0

	for j < numsLen {
		if nums[j] == 0 {
			temp := nums[i]
			nums[i] = nums[j]
			nums[j] = temp
			i++
		}
		j++
	}

	j = i

	for j < numsLen {
		if nums[j] == 1 {
			temp := nums[i]
			nums[i] = nums[j]
			nums[j] = temp
			i++
		}

		j++
	}
}