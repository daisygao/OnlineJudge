/*
Note: please assign initial size for ArrayList in Java or it won't pass the large test due to the time cost of each expansion operation of ArrayList.
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(10000);
        if (len < 4) return result;
        Arrays.sort(num);
        ArrayList<Integer> list = null;
        int i, j, k, m, sum;
        for (i = 0; i < len - 3; i++) {
            for (j = i + 1; j < len - 2; j++) {
                k = j + 1;
                m = len - 1;
                while (k < m) {
                    sum = num[i] + num[j] + num[k] + num[m];
                    if (sum == target) {
                        list = new ArrayList<Integer>(4);
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[m]);
                        result.add(list);
                        // move
                        while(++k < m && num[k] == num[k - 1]);
                    } else if (sum < target) {
                        while(++k < m && num[k] == num[k - 1]);
                    } else {
                        while(--m > k && num[m] == num[m + 1]);
                    }
                }
                while(j + 1 < len - 2 && num[j] == num[j + 1]) j++;
            }
            while(i + 1 < len - 3 && num[i] == num[i + 1]) i++;
        }
        return result;
    }
}