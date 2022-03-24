package programmers;

import java.util.Arrays;

public class Week25_k��������_�Ҽ�_����_���ϱ� {
	public static int solution(int n, int k) {
		String[] numbers = Integer.toString(n, k).split("0");

		return (int) Arrays.stream(numbers)
				.filter(s -> !s.isEmpty() && isPrime(Long.parseLong(s)))
				.count();
	}

	public static boolean isPrime(long n) {
		for (long i = 2; i * i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return n != 1;
	}
}

// �̰ŵ� 
//public static int solution(int n, int k) {
//String[] numbers = Integer.toString(n, k).split("0");
//int cnt = 0;
//
//for (String s : numbers) {
//	if (!s.isEmpty() && isPrime(Long.parseLong(s))) {
//		cnt++;
//	}
//}
//
//return cnt;
//}

