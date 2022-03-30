package programmers;

import java.util.Arrays;

public class Week27_최솟값_만들기 {
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int sum = 0, len = A.length;

		for (int i = 0; i < len; i++) {
			sum += A[i] * B[len - i - 1];
		}

		return sum;
	}
}
