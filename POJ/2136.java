import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws Exception {
		Scanner cin = new Scanner(System.in);
		int time = 4;
		int cnt[] = new int[26], max = Integer.MIN_VALUE;
		while (time-- > 0) {
			String s = cin.nextLine();
			for (int i = 0; i < s.length(); i++) {
				if (Character.isLetter(s.charAt(i))) {
					cnt[s.charAt(i) - 'A']++;
					max = Math.max(max, cnt[s.charAt(i) - 'A']);
				}
			}
		}
		for (int i = max; i >= 0; i--) {
			for (char c = 'A'; c <= 'Z'; c++) {
				char output = i == 0 ? c : (cnt[c - 'A'] >= i ? '*' : ' ');
				System.out.print(output);
				if (c != 'Z') System.out.print(" ");
			}
			System.out.println();
		}
	}
}