public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s == null) return true;
        int len = s.length();
        boolean sols[] = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if ((j == 0 || sols[j - 1]) && dict.contains(s.substring(j, i + 1))) {
                    sols[i] = true;
                    break;
                }
            }
        }
        return sols[len - 1];
    }
}