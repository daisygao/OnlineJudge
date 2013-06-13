public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0, min = Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int j = i + 1, k = num.length - 1;
            while (j < k) {
                int sum3 = num[i] + num[j] + num[k];
                if (Math.abs(sum3 - target) < min) {
                    min = Math.abs(sum3 - target);
                    result = sum3;
                }
                if (sum3 < target) {
                    while (j + 1 < k && num[j + 1] == num[j]) j++;
                    j++;
                } else if (sum3 > target) {
                    while (k - 1 > j && num[k - 1] == num[k]) k--;
                    k--;
                } else break;
            }
            while (i + 1 < num.length - 2 && num[i + 1] == num[i]) i++;
        }
        return result;
    }
}
