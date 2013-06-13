public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int slen = S.length(), llen = L.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (slen == 0 || llen == 0) return result;
        HashMap<String, Integer> cntMap = new HashMap<String, Integer>();
        HashMap<String, Integer> curCnt = new HashMap<String, Integer>();
        for (String l : L) {
            int cnt = cntMap.containsKey(l) ? cntMap.get(l) : 0;
            cntMap.put(l, cnt + 1);
        }
        int wlen = L[0].length();
        for (int i = 0; i <= slen - llen * wlen; i++) {
            curCnt.clear();
            boolean flag = true;
            for (int j = 0; j < llen; j++) {
                String str = S.substring(i + j * wlen, i + (j + 1) * wlen);
                if (cntMap.containsKey(str)) {
                    int cnt = curCnt.containsKey(str) ? curCnt.get(str) : 0;
                    if (cnt < cntMap.get(str)) {
                        curCnt.put(str, cnt + 1);
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            } 
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }
}