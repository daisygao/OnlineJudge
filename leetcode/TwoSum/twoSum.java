public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = numbers.length, head = 0, tail = len - 1, sum, pos[] = new int[len];
        for (int i = 0; i < len; i++) pos[i] = i + 1;
        sortWithIdx(numbers, pos, 0, len);
        while (head < tail) {
            sum = numbers[head] + numbers[tail];
            if (numbers[head] > 0 && numbers[tail] > 0 && sum < 0) tail--;
            else if (numbers[head] < 0 && numbers[tail] < 0 && sum > 0) head++;
            else if (sum == target) {
                int ans[] = {Math.min(pos[head], pos[tail]), Math.max(pos[head], pos[tail])};
                return ans;
            } else if (sum > target) tail--;
            else head++;
        }
        return null;
    }
    private void sortWithIdx(int[] numbers, int[] pos, int start, int end) {
        if (end < start + 1) return;
        int idx = partition(numbers, pos, start, end);
        sortWithIdx(numbers, pos, start, idx);
        sortWithIdx(numbers, pos, idx + 1, end);
    }
    private int partition(int[] numbers, int[] pos, int start, int end) {
        int i = start - 1, j = start, pivot = numbers[end - 1];
        while (j < end) {
            if (numbers[j] < pivot || j == end - 1) {
                int x = numbers[++i];
                numbers[i] = numbers[j];
                numbers[j] = x;
                x = pos[i];
                pos[i] = pos[j];
                pos[j] = x;
            }
            j++;
        }
        return i;
    }
}