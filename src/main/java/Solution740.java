import java.util.Arrays;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int[] points = calculatePoints(nums);
        int n = points.length;

        if (n == 1) return points[0];

        for (int i = 2; i < n; i++) {
            if (i > 2) points[i] = points[i] + Math.max(points[i - 2], points[i - 3]);
            else points[i] = points[i] + points[i - 2];
        }

        return Math.max(points[n - 1], points[n - 2]);
    }

    private int[] calculatePoints(int[] nums) {
        int max = max(nums);
        int[] points = new int[max + 1];

        for (int i : nums) {
            points[i] += i;
        }
        return points;
    }

    int max(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println(Arrays.toString(nums));
        System.out.println(new Solution740().deleteAndEarn(nums));
    }
}

