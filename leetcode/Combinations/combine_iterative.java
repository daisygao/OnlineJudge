public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(),
	    queue = new ArrayList<ArrayList<Integer>>();
        if (k == 0) return result;
        queue.add(new ArrayList<Integer>());
        int qidx = 0;
        while (qidx < queue.size()) {
            ArrayList<Integer> list = queue.get(qidx);
            int end = list.size() == 0 ? 0 : list.get(list.size() - 1);
            for (int i = end + 1; i <= n; i++) {
                ArrayList<Integer> newList = new ArrayList<Integer>(list);
                newList.add(i);
                if (newList.size() == k) result.add(newList);
                else queue.add(newList);
            }
            qidx++;
        }
        return result;
    }
}