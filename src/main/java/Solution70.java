public class Solution70 {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int preprev = 1;
        int prev = 2;

        for (int i = 2; i < n; i++) {
            int current = preprev + prev;
            preprev = prev;
            prev = current;
        }
        return prev;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(new Solution70().climbStairs(45));
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
