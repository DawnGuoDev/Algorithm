package main

func merge(nums1 []int, m int, nums2 []int, n int) {
	nums1Copy := make([]int, m)
	copy(nums1Copy, nums1)

	i := 0
	j := 0
	k := 0

	for ; i < m && j < n; k++ {
		if nums1Copy[i] < nums2[j] {
			nums1[k] = nums1Copy[i]
			i++
		} else {
			nums1[k] = nums2[j]
			j++
		}
	}

	for ; i < m; k++ {
		nums1[k] = nums1Copy[i]
	}

	for ; j < n; k++ {
		nums1[k] = nums2[j]
	}
}
