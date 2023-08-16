public class Solution62 {

    public int uniquePaths(int m, int n) {
        int steps = m + n - 2;
        int min = Math.min(m, n) - 1;

        long result = 1;
        for (int i = min + 1; i <= steps; i++) {
            result *= i;
            result /= i - min;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution62 solution = new Solution62();
        System.out.println(solution.uniquePaths(10, 10));
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}

