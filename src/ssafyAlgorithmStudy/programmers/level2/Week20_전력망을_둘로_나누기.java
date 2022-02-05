package programmers;

import java.util.*;

public class Week20_전력망을_둘로_나누기 {
	static int SIZE = 100;
	static ArrayList<Integer>[] list = new ArrayList[SIZE + 1];
	
	public static int solution(int n, int[][] wires) {
		for (int i = 0; i <= SIZE; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < wires.length; i++) {
			int from = wires[i][0];
			int to = wires[i][1];

			list[from].add(to);
			list[to].add(from);
		}

		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= SIZE; i++) {
			for (int next : list[i]) {
				int cnt = BFS(i, next);
				min = Math.min(min, Math.abs(cnt - (n - cnt)));
			}
		}

		return min;
	}

	public static int BFS(int pre, int cur) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(cur);
		boolean[] visited = new boolean[SIZE + 1];
		visited[pre] = true;
		visited[cur] = true;
		int cnt = 1;

		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int next : list[v]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
					cnt++;
				}
			}
		}

		return cnt;
	}
}
