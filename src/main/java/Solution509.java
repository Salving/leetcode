public class Solution509 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int preprev = 1;
        int prev = 1;

        for (int i = 2; i < n; i++) {
            int current = preprev + prev;
            preprev = prev;
            prev = current;
        }
        return prev;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution509().fib(4));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

