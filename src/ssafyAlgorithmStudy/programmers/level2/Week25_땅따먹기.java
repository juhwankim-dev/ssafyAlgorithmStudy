package programmers;

public class Week25_¶¥µû¸Ô±â {
	
	public int solution(int[][] land) {
		for (int i = 0; i < land.length - 1; i++) {
			int a = Math.max(land[i][1], Math.max(land[i][2], land[i][3]));
			int b = Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
			int c = Math.max(land[i][0], Math.max(land[i][1], land[i][3]));
			int d = Math.max(land[i][0], Math.max(land[i][1], land[i][2]));

			land[i + 1][0] += a;
			land[i + 1][1] += b;
			land[i + 1][2] += c;
			land[i + 1][3] += d;
		}

		int z = land.length - 1;
		return Math.max(land[z][0], Math.max(land[z][1], Math.max(land[z][2], land[z][3])));
	}
}
