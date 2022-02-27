package programmers;

import java.util.HashSet;

public class Week22_방문_길이 {
	static final int SIZE = 10;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { 1, -1, 0, 0 };

	public static int solution(String dirs) {
		StringBuilder sb = new StringBuilder();
		HashSet<String> hs = new HashSet<>();
		int y = 5, x = 5;

		for (int i = 0; i < dirs.length(); i++) {
			int dir = getDir(dirs.charAt(i));
			int newY = y + dy[dir];
			int newX = x + dx[dir];

			if (isMovable(newY, newX)) {
				sb.setLength(0);
				sb.append(y).append(x).append(newY).append(newX);

				if (!hs.contains(sb.toString())) {
					hs.add(sb.toString());
					sb.setLength(0);
					sb.append(newY).append(newX).append(y).append(x);
					hs.add(sb.toString());
				}

				y = newY;
				x = newX;
			}
		}

		return hs.size() / 2;
	}

	public static boolean isMovable(int y, int x) {
		if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
			return false;
		}

		return true;
	}

	public static int getDir(char c) {
		switch (c) {
		case 'R':
			return 0;
		case 'L':
			return 1;
		case 'D':
			return 2;
		default: // 'U'
			return 3;
		}
	}
}
