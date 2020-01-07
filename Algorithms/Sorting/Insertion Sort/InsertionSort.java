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
        for (int i = 1; i < n; i++)
            for (int j = i; j > 0; j--)
                if (data[j] < data[j-1]) {
                    int temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
        return data;
    }
}