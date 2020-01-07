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
        for (int h = 1; h < N / 3; h /= 3 + 1)
        {
            for (int i = h; i < n; i++)
            {
                int temp = data[i];
                int j;
                for (j = i; j >= h && data[j - h] > temp; j -= h)
                    data[j] = data[j - h];
                data[j] = temp;
            }
        }
        return data;
    }
}