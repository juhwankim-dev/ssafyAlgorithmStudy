package programmers;

import java.util.Arrays;

public class Week27_�ּڰ�_����� {
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
