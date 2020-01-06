import java.util.Arrays;

class BinarySearch {
    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        System.out.println("Before: " + Arrays.toString(data));
        int result = sort(data, 8);
        System.out.println("After:  " + result);
    }

    public static int sort(int[] data, int key) {
        int low = 0;
        int high = data.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if (key < data[mid]) high = mid - 1;
            else if (key > data[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}