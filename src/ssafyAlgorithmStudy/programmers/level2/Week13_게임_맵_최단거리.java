package programmers;

import java.util.*;

public class Week13_게임_맵_최단거리 {
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static int[][] maps;
	static boolean[][] visited;
	static int n, m, min = Integer.MAX_VALUE;

    public int solution(int[][] maps) {
		this.maps = maps;
		n = maps.length;
		m = maps[0].length;
		visited = new boolean[n][m];
		
		BFS(0, 0, 0);
		return (min == Integer.MAX_VALUE) ? -1 : min + 1;
	}

	public static void BFS(int y, int x, int moves) {
		Queue<Robot> queue = new LinkedList<>();
		queue.add(new Robot(y, x, moves));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Robot r = queue.poll();

			if (r.y == n - 1 && r.x == m - 1) {
				min = r.moves;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int newY = r.y + dy[i];
				int newX = r.x + dx[i];

				if (isRoad(newY, newX) && !visited[newY][newX]) {
					visited[newY][newX] = true;
					queue.add(new Robot(newY, newX, r.moves + 1));
				}
			}
		}
	}

	public static boolean isRoad(int y, int x) {
		if (y < 0 || x < 0 || y >= n || x >= m) {
			return false;
		}

		if (maps[y][x] == 0) {
			return false;
		}

		return true;
	}
}

class Robot {
	int y;
	int x;
	int moves;

	public Robot(int y, int x, int moves) {
		this.y = y;
		this.x = x;
		this.moves = moves;
	}
}