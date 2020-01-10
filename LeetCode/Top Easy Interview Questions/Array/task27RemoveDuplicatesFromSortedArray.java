public class task27RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] k = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(k));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                count++;
                nums[count] = nums[i];
            }
        }
        return count + 1;
    }
}

