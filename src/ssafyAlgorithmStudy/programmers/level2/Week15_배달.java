package programmers;

import java.util.*;

public class Week15_배달 {
	static int[][] map;

	public static int solution(int N, int[][] road, int K) {
		map = new int[N][N];

		// 초기화
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = 500001;
				}
			}
		}

		// 마을 별 최소 이동시간 구하기
		for (int i = 0; i < road.length; i++) {
			int from = road[i][0] - 1;
			int to = road[i][1] - 1;

			if (road[i][2] < map[from][to]) {
				map[from][to] = map[to][from] = road[i][2];
			}
		}

		// 플로이드
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (j != k) {
						if (map[j][k] > map[j][i] + map[i][k]) {
							map[j][k] = map[j][i] + map[i][k];
						}
					}
				}
			}
		}

		// 배달 가능한 지역 카운트
		int deliverableArea = 0;
		for (int dist : map[0]) {
			if (dist <= K) {
				deliverableArea++;
			}
		}

		return deliverableArea;
	}
}
