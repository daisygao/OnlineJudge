public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        dict.remove(start);
        dict.remove(end);
        if (dict.isEmpty()) return 0;
        ArrayList<String> active = new ArrayList<String>(), next = new ArrayList<String>();
        int dist = 0;
        active.add(start);
        while (!active.isEmpty() || !next.isEmpty()) {
            if (active.isEmpty()) {
                active.addAll(next);
                next.clear();
                dist++;
            }
            String current = active.remove(0);
            char arr[] = current.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                for (char j = 'a'; j < 'z'; j++) {
                    if (arr[i] == j) continue;
                    arr[i] = j;
                    String future = new String(arr);
                    if (dict.contains(future)) {
                        next.add(future);
                        dict.remove(future);
                    } else if (future.equals(end)) return dist + 2;
                }
                arr[i] = tmp;
            }
        }
        return 0;
    }
}