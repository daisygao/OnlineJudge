public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length(), idx = len - 1, res = 0;
        while (idx >= 0 && s.charAt(idx) == ' ') idx--;
        while (idx >= 0 && s.charAt(idx) != ' ') {
            idx--;
            res++;
        }
        return res;
    }
}