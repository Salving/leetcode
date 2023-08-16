import java.util.Arrays;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }
    public double findMedianSortedArraysDumb(int[] nums1, int[] nums2) {
        int[] combined = combineArrays(nums1, nums2);
        Arrays.parallelSort(combined);

        int length = combined.length;

        if (length % 2 == 0) {
            int a = (length - 2) / 2;
            int b = length / 2;

            return (combined[a] + combined[b]) / 2.0;
        } else {
            int middle = (int) Math.floor(length / 2.0);
            return combined[middle];
        }
    }

    private static int[] combineArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] combined = Arrays.copyOf(nums1, n + m);
        System.arraycopy(nums2, 0, combined, n, m);
        return combined;
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        test(solution, new int[]{1, 2, 3, 4, 5, 6, 7, 8}, new int[]{10, 11, 12, 13, 14, 15});
        test(solution, new int[]{1, 4, 8}, new int[]{10, 12, 13, 15});
    }

    private static void test(Solution4 solution, int[] nums1, int[] nums2) {
        System.out.println(solution.findMedianSortedArraysDumb(nums1, nums2));
    }
}
