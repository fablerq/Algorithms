import java.util.Arrays;

class SelectionSort {
    public static void main(String[] args) {
        int[] data = { 1, 5, 4, 8, 12, 2, 1, 2, 7, 9 };
        System.out.println("Before: " + Arrays.toString(data));
        data = sort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }

    public static int[] sort(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++)
        {
            int min = i;
            for (int j = i; j < n; j++)
            {
                if (data[j] < data[min]) min = j;
            }
            int temp = data[i];
            data[i] = data[min];
            data[min] = data[i];
        }
        return data;
    }
}