public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = triangle.size(), result = 0, width;
        if (size == 0) return 0;
        int sols[] = new int[size];
        ArrayList<Integer> list;
        for (int i = 0; i < size; i++) {
            list = triangle.get(i);
            width = list.size();
            for (int j = width - 1; j >= 0; j--) {
                int tmp = 0;
                if (j == 0) {
                    tmp = sols[j];
                } else if (j == width - 1) {
                    tmp = sols[j - 1];
                } else {
                    tmp = Math.min(sols[j - 1], sols[j]);
                }
                sols[j] = list.get(j) + tmp;
                if (i == size - 1) {
                    result = j == width - 1 ? sols[j] : (Math.min(result, sols[j]));
                }
            }
        }
        return result;
    }
}