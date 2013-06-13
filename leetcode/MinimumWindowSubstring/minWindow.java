public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int slen = S.length(), tlen = T.length(), cnt = 0, start = 0;
        int toFind[] = new int[256], found[] = new int[256];
        for (int i = 0; i < tlen; i++) {
            int key = (int)T.charAt(i);
            toFind[key]++;
        }
        int min = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < slen; i++) {
            int skey = (int)S.charAt(i);
            if (toFind[skey] > 0) {
                found[skey]++;
                if (found[skey] <= toFind[skey]) cnt++;
                if (cnt == tlen) {
                    while (start <= i) {
                        int key = (int)S.charAt(start);
                        if (toFind[key] > 0) {
                            if (toFind[key] == found[key]) break;
                            found[key]--;
                        }
                        start++;
                    }
                    if (i - start + 1 < min) {
                        min = i - start + 1;
                        result = S.substring(start, i + 1);
                    }
                    
                }
            }
        }
        return result;
    }
}