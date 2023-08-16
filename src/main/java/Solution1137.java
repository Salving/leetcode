public class Solution1137 {
    public int tribonacci(int n) {
        int[] prev = new int[]{0, 1, 1};

        if (n <= 2) return prev[n];

        for (int i = 2; i < n; i++) {
            int current = prev[2] + prev[1] + prev[0];
            prev[0] = prev[1];
            prev[1] = prev[2];
            prev[2] = current;
        }

        return prev[2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1137().tribonacci(25));
    }
}

