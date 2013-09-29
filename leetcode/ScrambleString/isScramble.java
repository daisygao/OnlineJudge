public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1 = s1.length(), l2 = s2.length();
        if (l1 != l2) return false;
        if (l1 <= 1) return s1.equals(s2);
        for (int l = 1; l < l1; l++) {
            String s11 = s1.substring(0, l), s12 = s1.substring(l);
            String s21 = s2.substring(0, l), s22 = s2.substring(l), s23 = s2.substring(l2 - l), s24 = s2.substring(0, l2 - l);
            if ((sameHash(s11, s21) && isScramble(s11, s21) && isScramble(s12, s22)) || 
            (sameHash(s11, s23) && isScramble(s11, s23) && isScramble(s12, s24))) return true;
        }
        return false;
    }
    boolean sameHash(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char c1[] = s1.toCharArray(), c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
    }
}