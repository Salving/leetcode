import java.util.Arrays;

public class Solution1648 {
    public int maxProfit(int[] inventory, int orders) {
        return 0;
    }

    public int maxProfitLoop(int[] inventory, int orders) {
        if (inventory.length == 1) {
            int first = inventory[0] - orders;
            int last = inventory[0];
            int result = (first + last) / 2 * orders;
            return result % (int) (Math.pow(10, 9) + 7);
        }

        int result = 0;
        for (; orders > 0; orders--) {
            boolean allZero = true;
            for (int j : inventory) {
                if (j > 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) return result;

            int maxIndex = 0;
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] > 0 && inventory[i] > inventory[maxIndex]) maxIndex = i;
            }

            int price = inventory[maxIndex];
            inventory[maxIndex]--;

            result = (result + price) % (int) (Math.pow(10, 9) + 7);
        }

        return result % (int) (Math.pow(10, 9) + 7);
    }


    public static void main(String[] args) {
        int[] inventory = new int[]{1000000000};
        int orders = 1000000000;

        System.out.println(new Solution1648().maxProfitLoop(inventory, orders));
    }
}
