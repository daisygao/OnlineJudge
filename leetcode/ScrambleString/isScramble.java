public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) return false;
        if (len2 == 1) return s1.equals(s2);
        boolean ret = false;
        for (int idx = 1; idx < len2; idx++) {
            String s21 = s2.substring(0, idx), s22 = s2.substring(idx);
            if (sameHash(s21, s1.substring(0, idx))) {
                ret = (isScramble(s1.substring(0, idx), s21) && isScramble(s1.substring(idx), s22));
            }
            if (ret) break;
            if (sameHash(s21, s1.substring(len2 - idx))) {
                ret = (isScramble(s1.substring(len2 - idx), s21) && isScramble(s1.substring(0, len2 - idx), s22));
            }
            if (ret) break;
        }
        return ret;
    }
    private boolean sameHash(String s1, String s2) {
        char arr1[] = s1.toCharArray(), arr2[] = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String news1 = new String(arr1), news2 = new String(arr2);
        return news1.equals(news2);
    }
}
