public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = numbers.length;
        if (len < 2) return null;
        int sols[] = new int[2];
        int idx[] = new int[len];
        for (int i = 0; i < len; i++) idx[i] = i + 1;
        sortWithIdx(numbers, idx, 0, len);
        int head = 0, tail = len - 1, sum;
        while (head < tail) {
            sum = numbers[head] + numbers[tail];
            if (numbers[head] > 0 && numbers[tail] > 0 && sum < 0) {tail--;}
            else if (numbers[head] < 0 && numbers[tail] < 0 && sum > 0) {head++;}
            else {
                if (sum == target) {
                    sols[0] = Math.min(idx[head], idx[tail]);
                    sols[1] = Math.max(idx[head], idx[tail]);
                    break;
                } else if (sum > target) {tail--;}
                else {head++;}
            }
        }
        return sols;
        
    }
    private void sortWithIdx(int[] num, int[] idx, int start, int end) {
        if (start < end) {
            int mid = partition(num, idx, start, end);
            sortWithIdx(num, idx, start, mid);
            sortWithIdx(num, idx, mid + 1, end);
        }
    }
    private int partition(int[] num, int[] idx, int start, int end) {
        int pivot = num[end - 1];
        int p = start - 1, q, tmp;
        for (q = start; q < end; q++) {
            if (num[q] < pivot || q == end - 1) {
                tmp = num[++p];
                num[p] = num[q];
                num[q] = tmp;
                tmp = idx[p];
                idx[p] = idx[q];
                idx[q] = tmp;
            }
        }
        return p;
    }
}