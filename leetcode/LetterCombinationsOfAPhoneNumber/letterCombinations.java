public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int idx[][] = {
	    {-1, -1},
	    {-1, -1},
	    {0, 2},
	    {3,5},
	    {6, 8},
	    {9, 11},
	    {12, 14},
	    {15, 18},
	    {19, 21},
	    {22, 25}
        };
        int len = digits.length();
        ArrayList<String> result = new ArrayList<String>(), buffer;
        result.add("");
        for (int i = 0; i < len; i++) {
            int num = digits.charAt(i) - '0';
            buffer = new ArrayList<String>();
            for (String s : result) {
                for (int j = idx[num][0]; j <= idx[num][1]; j++) {
                    buffer.add(s + alpha.charAt(j));
                }
            }
            result.clear();
            result.addAll(buffer);            
        }
        return result;
    }
}