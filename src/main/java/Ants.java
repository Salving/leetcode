import java.util.Random;

public class Ants {
    public int roundsLeftLoop(int n, int left, int right) {
        int rounds = 0;
        while (left >= 0 && right <= n) {
            if (left - right == 1) {
                int temp = right;
                right = left;
                left = temp;
            }

            left--;

            if (left - right == 1) {
                int temp = right;
                right = left;
                left = temp;

                left--;
            } else right++;

            rounds++;
        }

        return rounds;
    }

    public int roundsLeftMath(int n, int left, int right) {
        if (right > left) return Math.min(left, n - right) + 1;

        int rounds = Math.floorDiv((left - right), 2);
        if ((left - right) % 2 == 1)
            return rounds + roundsLeftMath(n, left - rounds - 1, right + rounds + 1);
        return rounds + roundsLeftMath(n, left - rounds - 2, right + rounds);
    }


    public static void main(String[] args) {
        test(4, 1, 3);
        test(4, 4, 1);
        test(4, 4, 3);
        test(3, 3, 1);
        test(15, 12, 5);
        test(1000, 3, 990);
        test(10000, 9999, 3);
        test(4, 4, 0);
        test(10, 3, 1);
        test(6, 5, 3);

        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            int n = random.nextInt(9999) + 1;
            int left = random.nextInt(n);
            int right = random.nextInt(n);
            if (left != right) test(n, left, right);
        }
    }

    public static void test(int n, int left, int right) {
        Ants ants = new Ants();
        System.out.print(ants.roundsLeftLoop(n, left, right));
        System.out.print(" | ");
        System.out.println(ants.roundsLeftMath(n, left, right));
        if (ants.roundsLeftLoop(n, left, right) != ants.roundsLeftMath(n, left, right)) throw new AssertionError();
    }
}
