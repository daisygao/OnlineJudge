import java.io.*;
import java.util.*;
public class Main {
	private static int getRevCnt(String s) {
		int rev = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') continue;
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) > s.charAt(j)) rev++;
			}
		}
		return rev;
	}
	public static void main(String args[]) throws Exception {
		Scanner cin = new Scanner(System.in);
		int size = cin.nextInt(), len = cin.nextInt(), i = 0;
		String arr[] = new String[len];
		while (i != len) {
			arr[i++] = cin.next();
		}
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return getRevCnt(o1) - getRevCnt(o2);
			}
		});
		for (String s : arr) {
			System.out.println(s);
		}
	}
}