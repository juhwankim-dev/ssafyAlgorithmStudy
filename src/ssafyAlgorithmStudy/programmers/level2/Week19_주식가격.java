package programmers;

import java.util.Stack;

public class Week19_주식가격 {
	public static int[] solution(int[] prices) {
		int len = prices.length;
		int[] answer = new int[len];

		Stack<Price> stack = new Stack<>();
		for (int i = 0; i < prices.length; i++) {
			while (!stack.isEmpty() && stack.peek().price > prices[i]) {
				Price pre = stack.pop();
				answer[pre.start] = i - pre.start;
			}

			stack.add(new Price(prices[i], i));
		}

		while (!stack.isEmpty()) {
			Price price = stack.pop();
			answer[price.start] = (len - 1) - price.start;
		}

		return answer;
	}
}

class Price {
	int price;
	int start;

	Price(int price, int start) {
		this.price = price;
		this.start = start;
	}
}