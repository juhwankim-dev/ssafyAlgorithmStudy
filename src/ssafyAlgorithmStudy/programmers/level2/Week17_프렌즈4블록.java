package programmers;

public class Week17_«¡∑ª¡Ó4∫Ì∑œ {
	static char[][] b;
	static int deleted = 0;

	public static int solution(int m, int n, String[] board) {
		b = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				b[i][j] = board[i].charAt(j);
			}
		}

		while (findSameBlocks(m, n)) {}

		return deleted;
	}

	public static boolean findSameBlocks(int m, int n) {
		boolean[][] visited = new boolean[m][n];
		boolean hasSameBlock = false;

		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (b[i][j] != '.' && b[i][j] == b[i][j + 1] && b[i][j] == b[i + 1][j] && b[i][j] == b[i + 1][j + 1]) {
					visited[i][j] = true;
					visited[i][j + 1] = true;
					visited[i + 1][j] = true;
					visited[i + 1][j + 1] = true;

					if (!hasSameBlock) {
						hasSameBlock = true;
					}
				}
			}
		}

		if (hasSameBlock) {
			markDeletedBlock(m, n, visited);
			moveDown(m, n);
		}

		return hasSameBlock;
	}

	public static void markDeletedBlock(int m, int n, boolean[][] visited) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					b[i][j] = '.';
					deleted++;
				}
			}
		}
	}

	public static void moveDown(int m, int n) {
		for (int i = 0; i < n; i++) {
			int emptyIdx = m - 1;
			int blockIdx = m - 1;

			while (true) {
				while (emptyIdx >= 0 && b[emptyIdx][i] != '.') {
					emptyIdx--;
				}

				blockIdx = emptyIdx;

				while (blockIdx >= 0 && b[blockIdx][i] == '.') {
					blockIdx--;
				}

				if (emptyIdx < 0 || blockIdx < 0) {
					break;
				}

				b[emptyIdx][i] = b[blockIdx][i];
				b[blockIdx][i] = '.';
				emptyIdx--;
				blockIdx--;
			}
		}
	}
}
