package programmers;

import java.util.*;

public class Week12_������ {
	public static int solution(int[] priorities, int location) {
		int[] docs = new int[10];
		Queue<Integer> queue = new LinkedList<>();
		for (int p : priorities) {
			docs[p]++;
			queue.add(p);
		}

		int order = 0;
		while (!queue.isEmpty()) {
			int highest = highestPriority(docs);

			// ���� ���� �켱������ ������ ���ö����� �ڷ� ������.
			while (queue.peek() != highest) {
				queue.add(queue.poll());
				location = (location > 0) ? location - 1 : queue.size() - 1;
			}

			order++;
			docs[queue.poll()]--;
			if (location == 0) break;
			else location--;
		}

		return order;
	}

	public static int highestPriority(int[] docs) {
		for (int i = 9; i >= 0; i--) {
			if (docs[i] > 0) return i;
		}

		return -1;
	}
}
