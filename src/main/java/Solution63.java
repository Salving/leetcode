import java.util.Arrays;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 1) grid[x][y] = 0;
                else if (x == 0 && y == 0) grid[x][y] = 1;
                else if (x == 0) grid[x][y] = grid[x][y - 1];
                else if (y == 0) grid[x][y] = grid[x - 1][y];
                else grid[x][y] = grid[x - 1][y] + grid[x][y - 1];
            }
        }

        int end = grid[m - 1][n - 1];
        if (end == Integer.MAX_VALUE) return 0;
        return end;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };

        long start = System.currentTimeMillis();
        Solution63 solution = new Solution63();
        System.out.println(solution.uniquePathsWithObstacles(grid));
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
