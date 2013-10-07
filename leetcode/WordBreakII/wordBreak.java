public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = s.length();
        ArrayList<ArrayList<Integer>>parent = new ArrayList<ArrayList<Integer>>(len);
        for (int i = 0; i < len; i++) {
            parent.add(new ArrayList<Integer>());
            for (int j = 0; j <= i; j++) {
                if (dict.contains(s.substring(j, i + 1)) && (j == 0 || parent.get(j - 1).size() != 0)) parent.get(i).add(j - 1);
            }
        }
        return helper(s, parent, len);
    }
    private ArrayList<String> helper(String s, ArrayList<ArrayList<Integer>> parent, int end) {
        ArrayList<String> ans = new ArrayList<String>();
        for (Integer x : parent.get(end - 1)) {
            String word = s.substring(x + 1, end);
            if (x == -1) ans.add(word);
            else {
                for (String sentence : helper(s, parent, x + 1)) {
                    ans.add(sentence + " " + word);
                }
            }
        }
        return ans;
    }
}