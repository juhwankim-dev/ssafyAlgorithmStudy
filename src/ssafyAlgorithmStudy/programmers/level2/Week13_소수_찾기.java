package programmers;

import java.util.*;

public class Week13_소수_찾기 {
	static HashSet<Integer> hs = new HashSet<>();
	static boolean[] isPrime;
	
	public static int solution(String numbers) {
		char[] _numbers = new char[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			_numbers[i] = numbers.charAt(i);
		}

		// 순열 만들기
		for (int i = 1; i <= _numbers.length; i++) {
			permutation(_numbers, 0, _numbers.length, i);
		}

		// 최대 값 구하기
		int max = 0;
		for (int num : hs) {
			if (num > max) max = num;
		}

		// 소수 구하기
		getPrimeNumber(max);

		// 소수 개수 구하기
		int cnt = 0;
		for (int num : hs) {
			if (isPrime[num]) cnt++;
		}

		return cnt;
	}

	static void permutation(char[] arr, int depth, int n, int r) {
		if (depth == r) {
			StringBuilder sb = new StringBuilder(r);
			int idx = 0;
			while (arr[idx] == '0') {
				idx++;
			}

			if (idx >= r) return;

			for (int i = idx; i < r; i++) {
				sb.append(arr[i]);
			}

			hs.add(Integer.parseInt(sb.toString()));
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(char[] arr, int depth, int i) {
		char temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	public static void getPrimeNumber(int max) {
		isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;

		for (int i = 2; i * i < max; i++) {
			for (int j = 2; i * j <= max; j++) {
				isPrime[i * j] = false;
			}
		}
	}
}
