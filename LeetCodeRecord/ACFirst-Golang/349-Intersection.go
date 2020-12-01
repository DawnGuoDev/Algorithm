package main

func intersection(nums1 []int, nums2 []int) []int {
	set1 := make(map[int]bool)
	for _, i := range nums1 {
		set1[i] = true
	}

	set2 := make(map[int]bool)
	for _, i := range nums2 {
		if _, ok := set1[i]; ok {
			set2[i] = true
		}
	}

	res := []int{}
	for i, _ := range set2 {
		res = append(res, i)
	}

	return res
}
