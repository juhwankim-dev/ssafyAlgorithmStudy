package programmers;

import java.util.*;

public class Week17_ū_��_����� {
	public static String solution(String number, int k) {
		String answer = "";
		Stack<Integer> stack = new Stack<Integer>();
		String rest = "";

		// ���ڿ� -> ���� ��ȯ�ؼ� ���ÿ� �ֱ�
		int numberSize = number.length();
		for (int i = 0; i < numberSize; i++) {
			while (!stack.isEmpty() && // ������ ������� �����鼭 ���� �� ���� �۴ٸ�
					stack.peek() < number.charAt(i) - '0') {
				stack.pop(); // �� ���� ��������.
				k--;

				if (k == 0)
					break;
			}

			stack.push(number.charAt(i) - '0');
			if (k == 0) {
				rest = number.substring(i + 1, numberSize);
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int num : stack) {
			sb.append(num);
		}

		answer = sb.toString() + rest;
		return answer;
	}
}
