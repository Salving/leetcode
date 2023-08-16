import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = 1; row < triangle.size(); row++) {
            for (int i = 0; i < triangle.get(row)
                    .size(); i++) {
                Integer minPath = Integer.MAX_VALUE;
                if (i < triangle.get(row)
                        .size() - 1) {
                    minPath = triangle.get(row - 1)
                            .get(i);
                }
                if (i > 0) {
                    minPath = Math.min(minPath, triangle.get(row - 1)
                            .get(i - 1));
                }
                triangle.get(row)
                        .set(i, minPath + triangle.get(row)
                                .get(i));
            }
        }

        int min = Integer.MAX_VALUE;
        for (Integer el : triangle.get(triangle.size() - 1)) {
            if (el < min) min = el;
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> lists = Arrays.stream(triangle)
                .map(ints -> Arrays.stream(ints)
                        .boxed()
                        .toList())
                .toList();

        System.out.println(new Solution120().minimumTotal(lists));
    }
}

