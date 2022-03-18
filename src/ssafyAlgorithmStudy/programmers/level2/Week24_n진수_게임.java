package programmers;

public class Week24_n진수_게임 {
	public static String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; sb.toString().length() / m <= t; i++) {
			sb.append(trasnNotation(i, n));
		}

		String s = sb.toString();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < t; i++) {
			result.append(s.charAt(m * i + p - 1));
		}

		return result.toString();
	}

	public static String trasnNotation(int num, int n) {
		StringBuilder sb = new StringBuilder();

		while (num / n != 0) {
			sb.append(intToString(num % n));
			num /= n;
		}
		sb.append(intToString(num % n));

		return sb.reverse().toString();
	}

	public static String intToString(int num) {
		if (num < 10) {
			return String.valueOf(num);
		}

		char ch = (char) ('A' + (num - 10));
		return String.valueOf(ch);
	}
}
