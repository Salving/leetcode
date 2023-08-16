import java.util.Arrays;

public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int maxSquare = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int minSide = Math.min(m, n);

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                char current = matrix[y][x];
                if (x > 0 && y > 0) {
                    char left = matrix[y][x - 1];
                    char up = matrix[y - 1][x];
                    char diagonal = matrix[y - 1][x - 1];
                    int min = Math.min(Math.min(left, up), diagonal);
                    if (current == '1' && min > 0) {
                        current = (char) ++min;
                    } else {
                        current = (char) (current == '1' ? 1 : 0);
                    }
                } else {
                    current = (char) (current == '1' ? 1 : 0);
                }
                if (current > maxSquare) maxSquare = current;
                matrix[y][x] = current;
            }
        }

        return maxSquare * maxSquare;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '1', '1'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        System.out.println(new Solution221().maximalSquare(matrix));
    }
}

