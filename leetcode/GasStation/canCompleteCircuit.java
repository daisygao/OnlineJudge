public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int len = gas.length, start = 0, i = 0;
        for (i = 0; i < len; i++) gas[i] -= cost[i];
        while (start < len) {
            int sum = 0;
            for (i = 0; i < len; i++) {
                sum += gas[(i + start) % len];
                if (sum < 0) {
                    start = start + i + 1;
                    break;
                }
            }
            if (i == len) return start;
        }
        return -1;
    }
}