public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String arr[] = s.split("\\s+");
        int len = arr.length;
        return len == 0 ? 0 : arr[len - 1].length();
    }
}