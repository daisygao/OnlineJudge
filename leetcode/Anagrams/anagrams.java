public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            char keyArr[] = str.toCharArray();
            Arrays.sort(keyArr);
            String key = new String(keyArr);
            ArrayList<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
            list.add(str);
            map.put(key, list);
        }
        ArrayList<String> result = new ArrayList<String>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) result.addAll(entry.getValue());
	}
        return result;
    }
}