import java.util.Arrays;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] rightSums = new int[n];

        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            rightSums[i] = sum;
            sum += nums[i];
        }

        sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum == rightSums[i]) return i;
            sum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(new Solution724().pivotIndex(nums));
    }
}

