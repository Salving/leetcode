import java.util.HashSet;
import java.util.Set;

public class Solution1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] variants = new int[]{tops[0], bottoms[0]};

        for (int i = 1; i < tops.length; i++) {
            for (int v = 0; v < variants.length; v++) {
                int variant = variants[v];
                if (variant != tops[i] && variant != bottoms[i]) variants[v] = 0;
            }
            if (variants[0] == 0 && variants[1] == 0) return -1;
        }

        int countTops = 0;
        int countBottoms = 0;
        int variant = variants[0] == 0 ? variants[1] : variants[0];

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == variant) countTops++;
            if (bottoms[i] == variant) countBottoms++;
        }

        return tops.length - Math.max(countTops, countBottoms);
    }

    public static void main(String[] args) {
        int[] tops = new int[]{1,2,1,1,1,2,2,2};
        int[] bottoms = new int[]{2,1,2,2,2,2,2,2};


        System.out.println(new Solution1007().minDominoRotations(tops, bottoms));
    }
}
