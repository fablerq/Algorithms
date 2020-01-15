import java.util.Arrays;

class InsertionSort {
    public static void main(String[] args) {
        int[] data = { 1, 5, 4, 8, 12, 2, 1, 2, 7, 9 };
        System.out.println("Before: " + Arrays.toString(data));
        data = sort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }

    public static int[] sort(int[] data) {
        int n = data.length;
        for (int i = 1; i < n; ++i) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j = j - 1;
            }
            data[j + 1] = key;
        }
        return data;
    }
}