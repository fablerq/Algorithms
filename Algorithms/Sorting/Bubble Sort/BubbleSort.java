class BubbleSort {
    public static int[] sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp    = data[j];
                    data[j]     = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }
}