package programmers;

public class Week17_ÇÇ·Îµµ {
	static boolean[] visited;
	static int max = 0;

	public int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		DFS(k, dungeons, 0);
		return max;
	}

	public static void DFS(int k, int[][] d, int cnt) {
		if (cnt > max) {
			max = cnt;
		}

		for (int i = 0; i < d.length; i++) {
			if (!visited[i]) {
				if (k >= d[i][0]) {
					visited[i] = true;
					DFS(k - d[i][1], d, cnt + 1);
					visited[i] = false;
				}
			}
		}
	}
}
