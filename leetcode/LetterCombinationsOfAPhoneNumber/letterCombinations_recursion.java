public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String dict[] = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        int len = digits.length();
        ArrayList<String> res = new ArrayList<String>();
        if (len == 0) {
            res.add("");
            return res;
        }
        int idx = digits.charAt(0) - '0';
        String val = dict[idx];
        for (String s : letterCombinations(digits.substring(1, len))) {           
            for (int i = 0; i < val.length(); i++) {
                res.add(new String(val.charAt(i) + s));
            }
        }
        return res;
    }
}