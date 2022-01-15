package programmers;

public class Week18_�ﰢ_������ {
	static int[] dy = { 1, 0, -1 };
	static int[] dx = { 0, 1, -1 };
	static int N;

	public static int[] solution(int n) {
		int[][] arr = new int[n][n];
		N = n;

		int y = -1, x = 0, cnt = 1;
		for (int i = 0; i < n; i++) {
			// �ѹ��ڱ��� ������ ������...
			y = y + dy[i % 3];
			x = x + dx[i % 3];

			while (isMovable(y, x) && arr[y][x] == 0) {
				arr[y][x] = cnt++;

				y = y + dy[i % 3];
				x = x + dx[i % 3];
			}

			// ������ �Ѿ����� ���� ��ġ��
			y = y + dy[i % 3] * -1;
			x = x + dx[i % 3] * -1;
		}

		int[] answer = new int[n * (n + 1) / 2];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				answer[idx++] = arr[i][j];
			}
		}

		return answer;
	}

	public static boolean isMovable(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N) {
			return false;
		}

		return true;
	}
}
