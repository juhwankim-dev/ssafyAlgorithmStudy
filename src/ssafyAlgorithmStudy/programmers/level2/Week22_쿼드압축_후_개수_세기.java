package programmers;

public class Week22_쿼드압축_후_개수_세기 {
	static int[] dy = { 0, 1, 0, 1 };
	static int[] dx = { 0, 0, 1, 1 };
	static int[] result = new int[2];

	public static void compress(int y, int x, int len, int[][] arr) {
		if (len == 1) {
			result[arr[y][x]]++;
			return;
		}

		if(isDivisible(y, x, len, arr)) {
			for (int i = 0; i < 4; i++) {
				int newY = y + (dy[i] * len / 2);
				int newX = x + (dx[i] * len / 2);

				compress(newY, newX, len / 2, arr);
			}
		} else {
			result[arr[y][x]]++;
		}
	}

	public static boolean isDivisible(int y, int x, int len, int[][] arr) {
		int num = arr[y][x];

		for (int i = y; i < y + len; i++) {
			for (int j = x; j < x + len; j++) {
				if (arr[i][j] != num) {
					return true;
				}
			}
		}

		return false;
	}
}
