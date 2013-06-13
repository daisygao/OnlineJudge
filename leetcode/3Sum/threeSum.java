public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len < 3) return result;
        Arrays.sort(num);
        int value, i, j, k, sum2;
        ArrayList<Integer> list = null;
        for (i = 0; i < len - 2; i++) {
            value = num[i];
            j = i + 1;
            k = len - 1;
            while (j < k) {
                sum2 = num[j] + num[k];
                if (sum2 + value == 0) {
                    list = new ArrayList<Integer>(); 
                    list.add(value);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);
                    while(j + 1 < len - 1 && num[j + 1] == num[j]) j++;
                    j++;
                } else if (sum2 + value < 0) {
                    while(j + 1 < len - 1 && num[j + 1] == num[j]) j++;
                    j++;
                } else {
                    while(k - 1 >= 0 && num[k - 1] == num[k]) k--;
                    k--;
                }
            }
            while(i + 1 < len - 2 && num[i + 1] == num[i]) i++;
        }
        return result;       
    }
}