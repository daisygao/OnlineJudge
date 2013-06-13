public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) return false;
        int cnt = 1;
        while (x / cnt >= 10) cnt *= 10;
        while (x > 0) {
            if (x / cnt != x % 10) return false;
            x %= cnt;
            x /= 10;
            cnt /= 100;
        }
        return true;
    }
}