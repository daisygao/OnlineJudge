public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1 = s1.length(), l2 = s2.length();
        if (l1 != l2) return false;
        char c1[] = s1.toCharArray(), c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!new String(c1).equals(new String(c2))) return false;
        if (l1 == 1) return true;
        for (int i = 1; i < l1; i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) || 
            (isScramble(s1.substring(0, i), s2.substring(l2 - i)) && isScramble(s1.substring(i), s2.substring(0, l2 - i)))) return true;
        }
        return false;
    }
}