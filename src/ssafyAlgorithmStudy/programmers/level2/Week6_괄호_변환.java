package ssafyAlgorithmStudy.programmers.level2;

import java.util.*;

public class Week6_괄호_변환 {
	public static String solution(String s) {
		return step1(s);
	}

	public static String step1(String s) {
		return s.isEmpty() ? s : step2(s);
	}

	public static String step2(String s) {
		int openCnt = 0;
		int closeCnt = 0;
		StringBuilder u = new StringBuilder();
		StringBuilder v = new StringBuilder(s);

		do {
			char c = v.charAt(0);
			if (c == '(') openCnt++;
			if (c == ')') closeCnt++;
			u.append(c);
			v.deleteCharAt(0);
		} while (openCnt != closeCnt);

		return step3(u.toString(), v.toString());
	}

	public static String step3(String u, String v) {
		return isAlright(u) ? u + step1(v) : step4(u, v);
	}

	public static String step4(String u, String v) {
		StringBuilder s = new StringBuilder();
		s.append('('); // 4-1
		s.append(step1(v)); // 4-2
		s.append(')'); // 4-3

		// 4-4, 4-5
		for(int i=1; i<u.length() - 1; i++) {
			if(u.charAt(i) == '(') s.append(')');
			else s.append('(');
		}
		
		return s.toString();
	}

	public static boolean isAlright(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty() || stack.peek() == ')') return false;
				else stack.pop();
			}
		}

		return true;
	}
}
