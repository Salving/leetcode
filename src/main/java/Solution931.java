public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int y = 1; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int minPath = matrix[y - 1][x];
                if (x > 0) minPath = Math.min(minPath, matrix[y-1][x-1]);
                if (x < n - 1) minPath = Math.min(minPath, matrix[y-1][x+1]);
                matrix[y][x] += minPath;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int el : matrix[n-1]) {
            if (el < min) min = el;
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {51, 24},
                {-50, 82},
        };

        long start = System.currentTimeMillis();
        System.out.println(new Solution931().minFallingPathSum(matrix));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

