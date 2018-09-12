import java.io.*;
import java.util.*;

public class Codeforces1036B {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int q = scanner.nextInt();
		for(int iQ = 0; iQ < q; iQ++) {
			long n = scanner.nextLong();
			long m = scanner.nextLong();
			long k = scanner.nextLong();
			long ans = 0;
			if(k < Math.max(n, m)) {
				ans = -1;
			}
			else if(n % 2 != m % 2) {
				ans = k - 1;
			}
			else if(k % 2 == Math.max(n, m) % 2) {
				ans = k;
			}
			else {
				ans = k - 2;
			}
			System.out.println(ans);
		}
	}
}