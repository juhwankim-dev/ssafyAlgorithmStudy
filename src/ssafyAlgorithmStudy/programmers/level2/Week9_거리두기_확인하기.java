package swea;

import java.util.*;

public class Week9_거리두기_확인하기 {
	static int[] result = new int[5];
	static boolean[][] visited;
	static char[][] map;
	static int[] dy = { 1, 0, 0 }; // ↓, →, ←
	static int[] dx = { 0, 1, -1 };

	public static int[] solution(String[][] places) {
		Arrays.fill(result, 1);
		
		for (int i = 0; i < 5; i++) {
			map = new char[5][5];
			visited = new boolean[5][5];
			
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					map[j][k] = places[i][j].charAt(k);
				}
			}
			
			label:for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if(map[j][k] == 'P') {
						visited[j][k] = true;
						dfs(i, j, k, 0);
					}
					
					if(result[i] == 0) {
						break label;
					}
				}
			}
		}

		return result;
	}
	
	public static void dfs(int room, int y, int x, int dist) {
		if(result[room] == 0 || dist >= 2) {
			return;
		}

		for(int i=0; i<3; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			
			if(check(newY, newX) && !visited[newY][newX]) {
				if(map[newY][newX] == 'P' && dist < 2) {
					result[room] = 0;
					break;
				}
				visited[newY][newX] = true;
				dfs(room, newY, newX, dist + 1);
				visited[newY][newX] = false;
			}
		}
	}
	
	public static boolean check(int y, int x) {
		if(y >= 5 || x >= 5 || x < 0) {
			return false;
		}
		
		if(map[y][x] == 'X') {
			return false;
		}
		
		return true;
	}
}
