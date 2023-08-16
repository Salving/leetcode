public class RLE {

    public String encode(String text) {
        StringBuilder sb = new StringBuilder();

        char[] chars = text.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            int count = 1;

            while (i + count < n - 1 && chars[i + count] == c) count++;

            sb.append(c);
            if (count > 1) sb.append(count);
            i += count - 1;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RLE().encode(""));
    }
}
