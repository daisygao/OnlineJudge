public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        do {
            result.add(getArrayList(num));
        } while (nextPermutation(num));
        return result;
    }
    private ArrayList<Integer> getArrayList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int x : arr) list.add(x);
        return list;
    }
    private boolean nextPermutation(int[] num) {
        int len = num.length, idx = len - 1;
        while (idx - 1 >= 0 && num[idx - 1] >= num[idx]) idx--;
        if (idx == 0) return false;
        int pos = idx, x = num[idx - 1];
        while (idx + 1 < len && num[idx + 1] > x) idx++;
        num[pos - 1] = num[idx];
        num[idx] = x;
        idx = len - 1;
        while (pos < idx) {
            x = num[pos];
            num[pos++] = num[idx];
            num[idx--] = x;
        }
        return true;
    }
}