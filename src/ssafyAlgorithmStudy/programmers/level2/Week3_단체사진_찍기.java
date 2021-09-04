package ssafyAlgorithmStudy.programmers.level2;

import java.util.*;

public class Week3_단체사진_찍기 {
	static String[] members = { "A", "C", "F", "J", "M", "N", "R", "T" };
	static final int MEMCNT = 8;
	static boolean[] visited = new boolean[MEMCNT];
	static ArrayList<String> orders = new ArrayList<>();

	public static int solution(int n, String[] data) {
		visited = new boolean[MEMCNT];
		orders = new ArrayList<>();
		dfs("", data);
		return orders.size();
	}

	public static void dfs(String str, String[] data) {
		if (str.length() == MEMCNT) {
			for (String d : data) {
				if (!isSuit(str, d)) {
					return;
				}
			}

			orders.add(str);
			return;
		}

		for (int i = 0; i < MEMCNT; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(str + members[i], data);
				visited[i] = false;
			}
		}
	}

	public static boolean isSuit(String order, String d) {
		int idx1 = order.indexOf(d.charAt(0));
		int idx2 = order.indexOf(d.charAt(2));
		char symbol = d.charAt(3);
		int dist1 = Math.abs(idx1 - idx2) - 1;
		int dist2 = d.charAt(4) - '0';

		if (symbol == '>') {
			if (dist1 <= dist2) {
				return false;
			}
		} else if (symbol == '<') {
			if (dist1 >= dist2) {
				return false;
			}
		} else {
			if (dist1 != dist2) {
				return false;
			}
		}

		return true;
	}
}