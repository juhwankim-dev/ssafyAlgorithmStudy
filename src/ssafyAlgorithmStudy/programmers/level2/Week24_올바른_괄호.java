package programmers;

import java.util.Stack;

public class Week24_올바른_괄호 {
	public boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		for(int i=0; i<s.length(); i++) {	
			if (s.charAt(i) == ')') {
				if (stack.isEmpty() || stack.peek() == ')') {
					return false;
				}

				stack.pop();
			} else {
				stack.add('(');
			}
		}

		return stack.isEmpty();
	}
}
