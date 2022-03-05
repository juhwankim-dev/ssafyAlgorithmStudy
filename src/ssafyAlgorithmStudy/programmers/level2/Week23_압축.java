package programmers;

import java.util.*;

public class Week23_æ–√‡ {
	static HashMap<String, Integer> hs = new HashMap<>();

	public static void main(String[] args) {
		Queue<Integer> queue = solution("KAKAO");
		for (int q : queue) {
			System.out.println(q);
		}
	}

	public static Queue<Integer> solution(String msg) {
		for (int i = 0; i < 26; i++) {
			char ch = (char) ('A' + i);
			hs.put(Character.toString(ch), i + 1);
		}

		Queue<Integer> queue = new LinkedList<>();
		int i = 0;
		while (i < msg.length()) {
			int nextIdx = getNextIdx(msg, i);
			queue.add(hs.get(msg.substring(i, nextIdx)));
			i = nextIdx;
		}

		return queue;
	}

	public static int getNextIdx(String msg, int curIdx) {
		for (int i = curIdx + 1; i <= msg.length(); i++) {
			if (!hs.containsKey(msg.substring(curIdx, i))) {
				hs.put(msg.substring(curIdx, i), hs.size() + 1);
				return i - 1;
			}
		}

		return msg.length();
	}
}
