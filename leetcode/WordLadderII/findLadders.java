
public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        dict.remove(start);
        dict.remove(end);
        HashMap<String, Integer> distmap = new HashMap<String, Integer>();
        HashMap<String, ArrayList<String>> parent = new HashMap<String, ArrayList<String>>();
        LinkedList<String> active = new LinkedList<String>();
        int dist = 0, idx = 0, wlen = start.length(), minDist = Integer.MAX_VALUE;
        active.add(start);
        distmap.put(start,dist);
        while (idx < active.size()) {
            String v = active.get(idx);
            dist = distmap.get(v);
            if (dist >= minDist) break;
            char varr[] = v.toCharArray();
            for (int i = 0; i < wlen; i++) {
                char tmp = varr[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j == tmp) continue;
                    varr[i] = j;
                    String u = new String(varr);
                    if (dict.contains(u) || u.equals(end)) {
                        if (parent.containsKey(u) && distmap.get(u) == dist + 1) {
                            parent.get(u).add(v);
                        } else if (!parent.containsKey(u)) {
                            ArrayList<String> plist = new ArrayList<String>();
                            plist.add(v);
                            parent.put(u, plist);
                            distmap.put(u, dist + 1);
                            active.add(u);
                        }
                        if (u.equals(end)) minDist = dist + 1;
                    }
                }
                varr[i] = tmp;
            }
            idx++;
        }
        return printPaths(end, parent, distmap);
    }
    ArrayList<ArrayList<String>> printPaths(String u, HashMap<String, ArrayList<String>> pa, HashMap<String, Integer> dist) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (pa.containsKey(u)) {
            for (String p : pa.get(u)) {
                for (ArrayList<String> list : printPaths(p, pa, dist)) {
                    list.add(u);
                    result.add(list);
                }
            }
        } else if (dist.containsKey(u)) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(u);
            result.add(list);
        }
        return result;
    }
}
