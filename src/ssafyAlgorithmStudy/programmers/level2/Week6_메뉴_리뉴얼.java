package ssafyAlgorithmStudy.programmers.level2;

import java.util.*;

public class Week6_메뉴_리뉴얼 {
	static String[] sortedOrders;
	static HashMap<String, Integer> hm = new HashMap<>();
	static int max;

	public static String[] solution(String[] orders, int[] courses) {
		sortedOrders = new String[orders.length];

		// orders안의 원소를 정렬해서 sortedOrders에 저장
		for (int i = 0; i < orders.length; i++) {
			char[] temp = orders[i].toCharArray();
			Arrays.sort(temp);
			sortedOrders[i] = String.valueOf(temp);
		}

		max = courses[courses.length - 1];
		for (String s : sortedOrders) {
			dfs("", s);
		}

		PriorityQueue<Config> pq = new PriorityQueue<>();
		for (String s : hm.keySet()) {
			pq.add(new Config(s, hm.get(s)));
		}

		Queue<String> queue = new LinkedList<>();
		for (int i = courses.length - 1; i >= 0; i--) {
			// courses에 들어있는 값이랑 똑같은 길이의 조합이 나올때까지 poll
			while (!pq.isEmpty() && pq.peek().menus.length() > courses[i]) {
				pq.poll();
			}

			// 가장 많이 주문된 조합찾기
			int cnt = pq.peek().cnt;
			if(cnt > 1) {
				while (!pq.isEmpty() && pq.peek().menus.length() == courses[i] && pq.peek().cnt == cnt) {
					queue.add(pq.poll().menus);
				}
			}
		}

		String[] result = new String[queue.size()];
		int i = 0;
		while(!queue.isEmpty()) {
			result[i++] = queue.poll();
		}
		Arrays.sort(result);
		
		return result;
	}

	public static void dfs(String orders, String s) {
		if (orders.length() <= max) {
			hm.put(orders, hm.getOrDefault(orders, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			dfs(orders + s.charAt(i), s.substring(i + 1, s.length()));
		}
	}
}

class Config implements Comparable<Config> {
	String menus;
	int cnt;

	Config(String menus, int cnt) {
		this.menus = menus;
		this.cnt = cnt;
	}

	public void increaseCnt() {
		this.cnt++;
	}

	@Override
	public int compareTo(Config o) {
		if (menus.length() == o.menus.length()) {
			return o.cnt - cnt;
		}

		return o.menus.length() - menus.length();
	}
}
