public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int slen = S.length(), llen = L.length;
        if (slen == 0 || llen == 0) return ans;
        int wlen = L[0].length();
        HashMap<String, Integer> needed = new HashMap<String, Integer>();
        for (String word : L) {
            int cnt = needed.containsKey(word) ? needed.get(word) : 0;
            needed.put(word, cnt + 1);
        }
        for (int i = 0; i <= slen - llen * wlen; i++) {
            int j = i, total = 0;
            HashMap<String, Integer> found = new HashMap<String, Integer>();
            while (j + wlen <= slen && total < llen) {
                String word = S.substring(j, j + wlen);
                int cnt = found.containsKey(word) ? found.get(word) : 0;
                if (needed.containsKey(word) && cnt < needed.get(word)) {
                    found.put(word, cnt + 1);
                    j += wlen;
                    total++;
                } else break;
            }
            if (total == llen) ans.add(i);
        }
        return ans;
    }
}