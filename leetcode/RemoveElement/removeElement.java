public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int start = 0, end = A.length - 1;
        while (start <= end) {
            while (start <= end && A[start] != elem) start++;
            while (end >= start && A[end] == elem) end--;
            if (start <= end) {
                int x = A[start];
                A[start] = A[end];
                A[end] = x;
            }
        }
        return end + 1;
    }
}