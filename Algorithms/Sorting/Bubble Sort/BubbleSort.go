func BubbleSort(data []int) {
	n := len(data)
	for i := 1; i < n-1; i++ {
		for j := n - 1; j >= i; j-- {
			if data[j] < data[j-1] {
				data[j], data[j-1] = data[j-1], data[i]
			}
		}
	}
}