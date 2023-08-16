import java.util.Arrays;

public class Solution283 {

    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (i != lastNonZeroIndex) {
                    nums[lastNonZeroIndex] = nums[i];
                }
                lastNonZeroIndex++;
            }
        }

        for (int i = lastNonZeroIndex; i < n; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        new Solution283().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

