import java.util.HashMap;
import java.util.List;

public class Solution139 {

    HashMap<String, Boolean> cache = new HashMap<>();

    public boolean wordBreak2(String s, List<String> wordDict) {
        if (cache.containsKey(s)) return cache.get(s);

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length()) return true;
                boolean canBreak = wordBreak2(s.substring(word.length()), wordDict);
                if (canBreak) {
                    cache.put(s, true);
                    return true;
                }
            }
        }

        cache.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa");
//        String s = "leetcode";
//        List<String> wordDict = List.of("leet", "code");

        Solution139 solution = new Solution139();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            solution.wordBreak2(s, wordDict);
            solution.cache.clear();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}

