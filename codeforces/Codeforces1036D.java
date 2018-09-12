import java.io.*;
import java.util.*;

public class Codeforces1036D {
	public static void main(String[] args) {
		MyScanner scanner = new MyScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int[] b = new int[m];
		for(int i = 0; i < m; i++) {
			b[i] = scanner.nextInt();
		}
		int i = 0;
		int j = 0;
		long sumA = a[0];
		long sumB = b[0];
		int ans = 0;
		while(i < n && j < m) {
			if(sumA == sumB) {
				ans++;
				i++;
				j++;
				if(i < n) {
					sumA = a[i];
				}
				if(j < m) {
					sumB = b[j];
				}
			}
			else if(sumA < sumB) {
				i++;
				if(i < n) {
					sumA += a[i];
				}
			}
			else {
				j++;
				if(j < m) {
					sumB += b[j];
				}
			}
		}
		if(i < n || j < m) {
			ans = -1;
		}
		System.out.println(ans);
	}
}

class MyScanner {
	private BufferedReader reader;
	private StringTokenizer tokens;

	public MyScanner(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
	}

	public String next() {
		while(tokens == null || !tokens.hasMoreElements()) {
			try {
				tokens = new StringTokenizer(reader.readLine());
			} catch(IOException error) {
				error.printStackTrace();
			}
		}
		return tokens.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}