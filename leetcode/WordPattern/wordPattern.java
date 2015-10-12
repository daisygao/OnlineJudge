public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            String word = words[i];
            char key = pattern.charAt(i);
            if (!map.containsKey(key) && !map.containsValue(word)) map.put(key, word);
            else if (!map.containsKey(key) ||
            !map.containsValue(word) ||
            !map.get(key).equals(word)) return false;
        }
        return true;
    }
}
