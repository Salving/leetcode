public class Solution1909 {
    public boolean canBeIncreasing(int[] nums) {
        int removeCount = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] <= nums[i]) {
                removeCount++;
                if (i != 0) {
                    if (nums[i + 1] <= nums[i - 1] && (nums.length - i > 2 && nums[i + 2] <= nums[i])) {
                        return false;
                    }
                }
            }
            if (removeCount > 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{105, 924, 32, 968};
        System.out.println(new Solution1909().canBeIncreasing(nums));
    }
}
