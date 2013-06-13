public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < len; i++) {
            String front = s.substring(0, i + 1);
            if (isPalin(front)) {
                ArrayList<ArrayList<String>> backs = partition(s.substring(i + 1));
                if (backs.isEmpty()) {
                    ArrayList<String> current = new ArrayList<String>();
                    current.add(front);
                    result.add(current);
                } else {
                    for (ArrayList<String> current : backs) {
                        current.add(0, front);
                        result.add(current);
                    }
                }
            }
        }
        return result;
    }
    private boolean isPalin(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) return false;
        }
        return true;
    }
}