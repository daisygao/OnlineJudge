public class Solution {
    public String minWindow(String S, String T) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int slen = S.length(), tlen = T.length(), start = 0, needed[] = new int[256], found[] = new int[256], count = 0, min = Integer.MAX_VALUE;
        String ans = "";
        if (tlen > slen) return ans;
        for (int i = 0; i < tlen; i++) needed[(int) T.charAt(i)]++;
        for (int i = 0; i < slen; i++) {
            int key = (int) S.charAt(i);
            if (needed[key] > 0) {
                found[key]++;
                if (found[key] <= needed[key]) count++;
                if (count == tlen) {
                    for (; start <= i; start++) {
                        key = (int) S.charAt(start);
                        if (needed[key] > 0) {
                            if (found[key] == needed[key]) {
                                if (min > i - start + 1) {
                                    min = i - start + 1;
                                    ans = S.substring(start, i + 1);
                                }
                                break;
                            }
                            found[key]--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}