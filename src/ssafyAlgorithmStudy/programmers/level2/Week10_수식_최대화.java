package programmers;

import java.util.*;

public class Week10_수식_최대화 {
	public static long solution(String expression) {
		// 숫자와 연산자를 분리해서 넣음
		ArrayList<Long> nums = new ArrayList<>();
		ArrayList<Character> ops = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(expression, "*|+|-", true);
		while (st.hasMoreTokens()) {
			nums.add(Long.parseLong(st.nextToken()));

			if (st.hasMoreTokens()) {
				ops.add(st.nextToken().charAt(0));
			}
		}

		// 연산자 순서 조합
		long answer = 0;
		ArrayList<Character> pri = new ArrayList<>(Arrays.asList('*', '+', '-'));
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				answer = Math.max(answer, getReward(nums, ops, pri));
				pri.add(pri.get(0));
				pri.remove(0);
			}
			Character temp = pri.remove(0);
			pri.add(pri.remove(0));
			pri.add(temp);
		}

		return answer;
	}

	public static long getReward(ArrayList<Long> n, ArrayList<Character> o, ArrayList<Character> pri) {
		ArrayList<Long> numList = new ArrayList<>(n);
		ArrayList<Character> operList = new ArrayList<>(o);

		for (int i = 0; i < pri.size(); i++) {
			char oper = pri.get(i);
			int size = operList.size();
			while (size-- > 0) {
				char curOper = operList.remove(0);
				long firstVal = numList.remove(0);

				if (oper == curOper) {
					long secondVal = numList.remove(0);
					numList.add(0, calc(firstVal, secondVal, oper));
				} else {
					operList.add(curOper);
					numList.add(firstVal);
				}
			}
			numList.add(numList.remove(0));
		}

		return Math.abs(numList.remove(0));
	}

	public static long calc(long a, long b, int c) {
		if (c == '-') return a - b;
		if (c == '+') return a + b;
		else return a * b;
	}
}
