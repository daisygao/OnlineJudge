public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        int len = words.length;
        int curTextLen = 0, newLen;
        int index = 0, start = 0;
        while (index < len) {
            newLen = (index - start) + curTextLen + words[index].length();
            if (newLen <= L) {
                curTextLen += words[index].length();
            } else {
                index--;
            }
            if (newLen >= L || index == len - 1) {                
                result.add(getJustifiedLine(words, start, index, L - curTextLen));
                start = index + 1;
                curTextLen = 0;
            }
            index++;
        }
        return result;
    }
    private String getJustifiedLine(String[] words, int head, int tail, int spaceTotalLen) {
        String result = "";  
        while (head <= tail) {
            result += words[head];
            int spaceCnt = tail - head;
            int spaceLen = 1;
            if (head == tail) {
                spaceLen = spaceTotalLen;
            } else if (tail != words.length - 1) {
                spaceLen = (int)Math.ceil(1.0 * spaceTotalLen / spaceCnt); 
            }
            result += getSpaceString(spaceLen);
            head++;
            spaceTotalLen -= spaceLen;
        }
        return result;
    }
    private String getSpaceString(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result += " ";
        }
        return result;
    }
}