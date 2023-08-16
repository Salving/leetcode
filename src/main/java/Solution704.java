import java.util.Arrays;

public class Solution704 {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    public int search(int[] nums, int target, int from, int to) {
        int n = to - from;
        if (n < 0) return -1;

        int middle = Math.floorDiv((n - 1), 2) + from;

        if (nums[middle] == target) return middle;
        else if (n == 0) return -1;
        else if (target > nums[middle]) return search(nums, target, middle + 1, to);
        else return search(nums, target, from, middle - 1);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 5};

        System.out.println(new Solution704().search(nums, -5));
    }
}
