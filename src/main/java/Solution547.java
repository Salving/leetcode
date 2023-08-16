import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<Integer> remainingCities = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            remainingCities.add(i);
        }

        return provincesNumber(isConnected, remainingCities);
    }

    private int provincesNumber(int[][] table, List<Integer> remainingCities) {
        List<Integer> cities = connectedCities(table, remainingCities.get(0));
        remainingCities.removeAll(cities);

        if (!remainingCities.isEmpty()) {
            return 1 + provincesNumber(table, remainingCities);
        }

        return 1;
    }

    private List<Integer> connectedCities(int[][] table, int city) {
        LinkedList<Integer> connected = new LinkedList<>();

        for (int i = 0; i < table.length; i++) {
            if (table[i][city] == 1) connected.add(i);
        }

        return connected;
    }

    public static void main(String[] args) {

    }
}
