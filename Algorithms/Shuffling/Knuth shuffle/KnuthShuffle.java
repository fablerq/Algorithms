import java.util.Arrays;
import java.util.Random;

class KnuthShuffle {
    public static void main(String[] args) {
        int[] data = {1, 5, 4, 8, 12, 2, 1, 2, 7, 9};
        System.out.println("Before: " + Arrays.toString(data));
        data = shuffle(data);
        System.out.println("After:  " + Arrays.toString(data));
    }

    public static int[] shuffle(int[] data) {
        int n = data.length;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            int r = rand.nextInt(i + 1);
            int temp = data[i];
            data[i] = data[r];
            data[r] = temp;
        }
        return data;
    }
}