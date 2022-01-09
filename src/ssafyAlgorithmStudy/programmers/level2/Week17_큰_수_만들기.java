package programmers;

import java.util.*;

public class Week17_큰_수_만들기 {
	public static String solution(String number, int k) {
		String answer = "";
		Stack<Integer> stack = new Stack<Integer>();
		String rest = "";

		// 문자열 -> 숫자 변환해서 스택에 넣기
		int numberSize = number.length();
		for (int i = 0; i < numberSize; i++) {
			while (!stack.isEmpty() && // 스택이 비어있지 않으면서 먼저 들어간 값이 작다면
					stack.peek() < number.charAt(i) - '0') {
				stack.pop(); // 그 값을 빼버리자.
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
