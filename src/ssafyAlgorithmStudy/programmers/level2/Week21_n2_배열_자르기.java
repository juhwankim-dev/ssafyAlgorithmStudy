package programmers;

import java.util.*;

public class Week21_n2_�迭_�ڸ��� {

	public Queue<Long> solution(int n, long left, long right) {
		long y, x;

		Queue<Long> queue = new LinkedList<>();
		for (long i = left; i <= right; i++) {
			y = i / n;
			x = i % n;
			queue.add((y > x) ? y + 1 : x + 1);
		}

		return queue;
	}
}
