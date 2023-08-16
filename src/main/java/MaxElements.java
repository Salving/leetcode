import java.util.Arrays;
import java.util.Random;

public class MaxElements {
    static int[] findTwoMaxElements(int[] arr) {
        if (arr.length <= 2) return arr;

        int cmps = 0;

        int max = arr[0];
        int secondMax = arr[1];

        if (secondMax > max) {
            int temp = max;
            max = secondMax;
            secondMax = temp;
        }
        cmps++;

        for (int i = 2; i < arr.length; i++) {
            cmps++;
            if (arr[i] >= secondMax) {
                secondMax = arr[i];
                cmps++;
                if (secondMax > max) {
                    int temp = max;
                    max = secondMax;
                    secondMax = temp;
                }
            }
        }

        System.out.printf("Comparisons: %d\n", cmps);
        return new int[]{secondMax, max};
    }

    public static void main(String[] args) {
        int size = 1000;
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(size * 2);
//            arr[i] = arr.length - i;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(findTwoMaxElements(arr)));

        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1]);
        System.out.println(arr[arr.length - 2]);
    }
}
