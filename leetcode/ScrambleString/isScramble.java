public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s1.length();
        if (len != s2.length()) return false;
        else if (len == 0) return true;
        else if (len == 1) return s1.equals(s2);
        for (int i = 1; i < len; i++) {
            String s21 = s2.substring(0, i), s22 = s2.substring(i), 
		s11 = s1.substring(0, i), s12 = s1.substring(len - i);
            boolean ret = (sameHash(s21, s11) && isScramble(s21, s11) && isScramble(s22, s1.substring(i))) ||
		(sameHash(s21, s12) && isScramble(s21, s12) && isScramble(s22, s1.substring(0, len - i)));
            if (ret) return true;
        }
        
        return false;
    }
    private boolean sameHash(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char arr1[] = s1.toCharArray(), arr2[] = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String ans1 = new String(arr1), ans2 = new String(arr2);
        return ans1.equals(ans2);
    }
}