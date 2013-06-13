public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int height = matrix.length;
        if (height == 0) return 0;
        int width = matrix[0].length, left[] = new int[width], 
	    right[] = new int[width], hist[] = new int[width], max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                left[j] = j;
                right[j] = j;
            }            
            for (int j = 0; j < width; j++) {
                hist[j] = matrix[i][j] == '1' ? hist[j] + 1 : 0;
                while (left[j] - 1 >= 0 && hist[left[j] - 1] >= hist[j]) {
                    left[j] = left[left[j] - 1];
                }
            }
            for (int j = width - 1; j >= 0; j--) {
                while (right[j] + 1 < width && hist[right[j] + 1] >= hist[j]) {
                    right[j] = right[right[j] + 1];
                }
                max = Math.max(max, (right[j] - left[j] + 1) * hist[j]);
            }
        }
        return max;
    }
}