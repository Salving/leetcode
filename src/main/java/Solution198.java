public class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        for (int i = 2; i < n; i++) {
            if (i > 2) nums[i] = nums[i] + Math.max(nums[i - 2], nums[i - 3]);
            else nums[i] = nums[i] + nums[i - 2];
        }

        return Math.max(nums[n - 1], nums[n - 2]);
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2};
        System.out.println(new Solution198().rob(nums));
    }
}

