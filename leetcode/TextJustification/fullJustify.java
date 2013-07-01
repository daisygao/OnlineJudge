public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = words.length, start = 0, end = -1;
        ArrayList<String> ans = new ArrayList<String>();
        while (start < len) {
            int wordsLen = 0;
            StringBuilder sb = new StringBuilder();
            while (end + 1 < len && end + 1 - start + wordsLen + words[end + 1].length() <= L) {
                wordsLen += words[++end].length();
            }
            int space = L - wordsLen, slot;
            for (int i = start; i <= end; i++) {
                sb.append(words[i]);
                slot = end == i ? space : (end == len - 1 ? 1 : (int)Math.ceil(1.0 * space / (end - i)));
                for (int j = 0; j < slot; j++) {
                    sb.append(" ");
                }
                space -= slot;
            }
            ans.add(sb.toString());
            start = end + 1;
        }
        return ans;
    }
}