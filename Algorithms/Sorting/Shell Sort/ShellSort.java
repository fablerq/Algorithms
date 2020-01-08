import java.util.Arrays;

class ShellSort {
    public static void main(String[] args) {
        int[] data = { 1, 5, 4, 8, 12, 2, 1, 2, 7, 9 };
        System.out.println("Before: " + Arrays.toString(data));
        data = sort(data);
        System.out.println("After:  " + Arrays.toString(data));
    }

    public static int[] sort(int[] data) {
        int n = data.length, h = 1;
        while (h < n / 3) h = 3 * h + 1;
        while(h > 0)
        {
            for (int i = h; i < n; i++)
            {
                for (int j = i; j >= h && data[j - h] > data[j]; j -= h)
                {
                    int temp = data[j];
                    data[j] = data[j - h];
                    data[j - h] = temp;
                }
            }
            h = h / 3;
        }
        return data;
    }
}