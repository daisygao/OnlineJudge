public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ele[] = new int[n];
        for (int i = 0; i < n; i++) ele[i] = i + 1;
        while (--k > 0) nextPermutation(ele, n); 
        StringBuilder sb = new StringBuilder();
        for (int x : ele) sb.append(x);
        return sb.toString();
    }
    private void nextPermutation(int[] arr, int len) {
        int idx = len - 1;
        while (idx >= 0 && arr[idx - 1] >= arr[idx]) idx--;
        int pos = idx;
        if (idx > 0) {
            int x = arr[idx - 1];
            while (idx + 1 < len && arr[idx + 1] > x) idx++;
            arr[pos - 1] = arr[idx];
            arr[idx] = x;
        }
        idx = len - 1;
        while (pos < idx) {
            int x = arr[pos];
            arr[pos++] = arr[idx];
            arr[idx--] = x;
        }
    }
}