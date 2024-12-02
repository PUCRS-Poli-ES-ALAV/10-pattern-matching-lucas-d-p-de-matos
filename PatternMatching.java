public class PatternMatching {
    
    public static int firstPatterMatchingIndex(String str, String pattern) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == pattern.charAt(0)) {
                for (int j = 1; j < pattern.length(); j++) {
                    if (str.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                    if (j + 1 == pattern.length()) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }

    public static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);
     
        for (int i = 0; i <= N - M; i++) {
            long txtHash = hash(txt.substring(i, i+M), M);
            if (patHash == txtHash) {
                return i;
            }
        }
        return N;
    }

    private static long hash(String s, int M) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (h * 26 + s.charAt(i)) % 2147483647;
        }
        return h;
    }

    public static void testFirstPatterMatchingIndex() {
        for (int casos = 1; casos < 20; casos++) {
            int testSize = (int) Math.pow(2, casos);

            String str = "";
            String pattern = "abcd";

            for (int i = 0; i < testSize; i++) {
                str += "a";
            }

            str+= "bcd";

            long startTime1 = System.nanoTime();
            firstPatterMatchingIndex(str, pattern);
            long endTime1 = System.nanoTime();

            double time = (endTime1 - startTime1) / 10000.0;

            System.out.println(testSize + "," + time);
        }
    }
}
