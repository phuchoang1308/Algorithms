import java.io.*;
import java.util.*;

public class Codeforces1036C {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTest = scanner.nextInt();
		for(int iTest = 0; iTest < nTest; iTest++) {
			long l = scanner.nextLong();
			long r = scanner.nextLong();
			long ans = countClassy(r, 3) - countClassy(l - 1, 3);
			System.out.println(ans);
		}
	}

	private static long countClassy(long n, int maxNumNonZeros) {
		Map<CountInfoWrapper, Long> memo = new HashMap<>();
		return recursiveCountClassy(memo, Long.toString(n), maxNumNonZeros, 0, false, 0);
	}

	private static long recursiveCountClassy(Map<CountInfoWrapper, Long> memo, String strN, int maxNumNonZeros, int pos, boolean isSmaller, int numNonZeros) {
		if(pos == strN.length()) {
			return 1;
		}
		CountInfoWrapper info = new CountInfoWrapper(pos, isSmaller, numNonZeros);
		if(memo.containsKey(info)) {
			return memo.get(info);
		}
		long result = 0;
		for(int i = 0; i < 10; i++) {
			if(!isSmaller && i > Character.digit(strN.charAt(pos), 10)) {
				continue;
			}
			if(numNonZeros == maxNumNonZeros && i != 0) {
				continue;
			}
			int nextPos = pos + 1;
			boolean nextIsSmaller = isSmaller || i < Character.digit(strN.charAt(pos), 10);
			int nextNumNonZeros = numNonZeros;
			if(i != 0) {
				nextNumNonZeros++;
			}
			result += recursiveCountClassy(memo, strN, maxNumNonZeros, nextPos, nextIsSmaller, nextNumNonZeros);
		}
		memo.put(info, result);
		return result;
	}
}

class CountInfoWrapper {
	private int pos;
	private boolean isSmaller;
	private int numNonZeros;

	public CountInfoWrapper(int pos, boolean isSmaller, int numNonZeros) {
		this.pos = pos;
		this.isSmaller = isSmaller;
		this.numNonZeros = numNonZeros;
	}

	public boolean equals(Object object) {
		CountInfoWrapper other = (CountInfoWrapper)object;
		return pos == other.pos && isSmaller == other.isSmaller && numNonZeros == other.numNonZeros;
	}

	public int hashCode() {
		int result = pos;
		result = result * 31 + (isSmaller ? 1 : 0);
		result = result * 31 + numNonZeros;
		return result;
	}
}