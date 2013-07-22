import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws Exception {
		Scanner cin = new Scanner(System.in);
		float sum = 0;
		while (cin.hasNext()) {
			sum += cin.nextFloat();
		}
		System.out.println("$" + String.format("%.2f", sum / 12));
	}
}