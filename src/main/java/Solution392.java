public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int sSize = s.length();
        int tSize = t.length();
        int tIndex = 0;

        for (int sIndex = 0; sIndex < sSize; sIndex++) {
            while (tIndex < tSize) {
                if (s.charAt(sIndex) == t.charAt(tIndex)) {
                    break;
                }
                tIndex++;
            }
            tIndex++;
            if (tIndex > tSize) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution392().isSubsequence("aaaaaa", "bbaaaa"));
    }
}


