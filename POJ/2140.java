import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws Exception {
		Scanner cin = new Scanner(System.in);
		int num = cin.nextInt(), low = 1, high = low, sum = low, cnt = 0;
		while (high <= num && low <= high) {
			if (sum < num) {
				high++;
				sum += high;
			}
			if (sum > num) {
				sum -= low;
				low++;
			}
			if (sum == num) {
				cnt++;
				high++;
				sum += high;
			}
		}
		System.out.println(cnt);
	}
}