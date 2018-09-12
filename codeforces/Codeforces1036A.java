import java.io.*;
import java.util.*;

public class Codeforces1036A {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long k = scanner.nextLong();
		long ans = (k + n - 1) / n;
		System.out.println(ans);
	}
}