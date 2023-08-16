import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int n = chars1.length;
        int m = chars2.length;
        char[] result = new char[n + m];

        int index1 = 0, index2 = 0;
        int rn = result.length;

        while (index1 + index2 < rn) {
            char nextChar = 0;
            if (index1 < n && index1 == index2) nextChar = chars1[index1++];
            else if (index2 < m) nextChar = chars2[index2++];
            else nextChar = chars1[index1++];
            result[index1 + index2 - 1] = nextChar;
        }

        return String.copyValueOf(result);
    }

    public String mergeAlternatelyWithoutArrays2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] result = new char[n + m];

        int index1 = 0, index2 = 0;
        int rn = result.length;

        while (index1 + index2 < rn) {
            if (index1 < n) result[index1 + index2] = word1.charAt(index1++);
            if (index2 < m) result[index1 + index2] = word2.charAt(index2++);
        }

        return String.copyValueOf(result);
    }

    public String mergeAlternatelyConcat(String word1, String word2) {
        int index1 = 0, index2 = 0;
        String result = "";

        while (index1 + index2 < word1.length() + word2.length()) {
            char nextChar = 0;
            if (index1 < word1.length() && index1 == index2) nextChar = word1.charAt(index1++);
            else if (index2 < word2.length()) nextChar = word2.charAt(index2++);
            else nextChar = word1.charAt(index1++);
            result += nextChar;
        }

        return result;
    }

    public String mergeAlternatelyBuilder(String word1, String word2) {
        int index1 = 0, index2 = 0;
        StringBuilder result = new StringBuilder();

        while (index1 + index2 < word1.length() + word2.length()) {
            char nextChar = 0;
            if (index1 < word1.length() && index1 == index2) nextChar = word1.charAt(index1++);
            else if (index2 < word2.length()) nextChar = word2.charAt(index2++);
            else nextChar = word1.charAt(index1++);
            result.append(nextChar);
        }

        return result.toString();
    }

    public String mergeAlternatelyWithoutArrays(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] result = new char[n + m];

        int index1 = 0, index2 = 0;
        int rn = result.length;

        while (index1 + index2 < rn) {
            char nextChar = 0;
            if (index1 < n && index1 == index2) nextChar = word1.charAt(index1++);
            else if (index2 < m) nextChar = word2.charAt(index2++);
            else nextChar = word1.charAt(index1++);
            result[index1 + index2 - 1] = nextChar;
        }

        return String.copyValueOf(result);
    }

    public static void main(String[] args) throws IOException {
        Solution1768 solution = new Solution1768();

        System.out.println("Warmup");
        int iterations = 0;

        PrintStream out = System.out;
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {}
        }));

        while (iterations < 2) {
            System.out.println("\nArray merge");
            run(solution::mergeAlternately);

            System.out.println("\nArray merge w/o arrays");
            run(solution::mergeAlternatelyWithoutArrays);

            System.out.println("\nArray merge w/o arrays simplified");
            run(solution::mergeAlternatelyWithoutArrays);
//
//            System.out.println("\nString concat");
//            run(solution::mergeAlternatelyConcat);
//
//            System.out.println("\nString builder");
//            run(solution::mergeAlternatelyBuilder);

            iterations++;
            System.setOut(out);
        }
    }
    static Random random = new Random();
    private static void run(BiFunction<String, String, String> function) {
        int iterations = 100;
        List<Long> times = new ArrayList<>(iterations);

        for (int j = 0; j < iterations; j++) {
            List<String> results = new ArrayList<>(10000);

            long start = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                String word1 = String.valueOf(random.nextLong());
                String word2 = String.valueOf(random.nextLong());
                String merged = function.apply(word1, word2);
                results.add(merged);
            }
            long end = System.currentTimeMillis();
            times.add(end - start);
            results.isEmpty();
        }
        System.out.printf("Average time elapsed: %d ms\n", times.stream()
                .reduce(Long::sum)
                .orElse(1L) / iterations);

        System.out.printf("Minimum time: %d ms\n", times.stream()
                .min(Long::compareTo)
                .orElse(0L));
        System.out.printf("Maximum time: %d ms\n", times.stream()
                .max(Long::compareTo)
                .orElse(0L));
    }
}
