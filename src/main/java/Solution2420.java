import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Solution2420 {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> nonIncreasing = nonIncreasing(nums, k);
        List<Integer> nonDecreasing = nonDecreasing(nums, k);

        return intersection(nonIncreasing, nonDecreasing);
    }

    static List<Integer> nonIncreasing(int[] nums, int k) {
        int[] niCounts = new int[nums.length];
        int counter = 1;
        for (int i = 0; i < nums.length - k; i++) {
            if (i == 0) {
                niCounts[i] = counter++;
                continue;
            }
            int prev = nums[i - 1];
            if (prev < nums[i]) counter = 1;
            niCounts[i] = counter++;
        }

        LinkedList<Integer> indices = new LinkedList<>();

        for (int i = k; i < niCounts.length - k; i++) {
            if (niCounts[i - 1] >= k) indices.add(i);
        }

        return indices;
    }

    static List<Integer> nonDecreasing(int[] nums, int k) {
        int[] niCounts = new int[nums.length];
        int counter = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                niCounts[i] = counter++;
                continue;
            }
            int prev = nums[i + 1];
            if (prev < nums[i]) counter = 1;
            niCounts[i] = counter++;
        }

        LinkedList<Integer> indices = new LinkedList<>();

        for (int i = k; i < niCounts.length - k; i++) {
            if (niCounts[i + 1] >= k) indices.add(i);
        }

        return indices;
    }

    static List<Integer> intersection(List<Integer> a, List<Integer> b) {
        LinkedList<Integer> list = new LinkedList<>();
        int aSize = a.size();
        int bSize = b.size();
        while (aSize > 0 && bSize > 0) {
            Integer left = a.get(0);
            Integer right = b.get(0);
            if (Objects.equals(left, right)) {
                list.add(left);
                a.remove(0);
                b.remove(0);
                aSize--;
                bSize--;
            } else if (left > right) {
                b.remove(0);
                bSize--;
            } else {
                a.remove(0);
                aSize--;
            }
        }

        return list;
    }

    public static void main(String[] args) throws IOException {
//        int[] nums = new int[]{878724, 201541, 179099, 98437, 35765, 327555, 475851, 598885, 849470, 943442};
//        int k = 4;
        int[] nums = new int[]{2, 1, 1, 1, 3, 4, 1};
        int k = 2;


        Solution2420 solution = new Solution2420();
        Date start = new Date();
        List<Integer> result = solution.goodIndices(nums, k);
        Date end = new Date();

        System.out.println(result);
        System.out.println("time:");
        System.out.println(end.getTime() - start.getTime());
    }
}
