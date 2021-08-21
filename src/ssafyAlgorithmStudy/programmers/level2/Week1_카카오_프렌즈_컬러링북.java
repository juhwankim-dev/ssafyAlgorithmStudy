package ssafyAlgorithmStudy.programmers.level2;

public class Week1_카카오_프렌즈_컬러링북 {
	static boolean[][] visited;
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int cnt; // 한 지역이 몇 칸으로 이루어져있는지 카운트
	static int cntArea; // 그림에 몇개의 영역이 있는지 카운트
	static int maxArea; // 가장 큰 영역이 몇칸인지
	static int limitY;
	static int limitX;
	
	public static void main(String[] args) {

	}

	public int[] solution(int m, int n, int[][] picture) {
		visited = new boolean[m][n];
        cntArea = 0;
		maxArea = 0;
		limitY = m;
		limitX = n;
		
		for (int y = 0; y < m; y++) {
			for (int x = 0; x < n; x++) {
				if (!visited[y][x] && picture[y][x] != 0) {
					cnt = 0;
					cntArea++;
					dfs(picture, y, x);
					maxArea = Math.max(maxArea, cnt);
				}
			}
		}
		
		int[] answer = { cntArea, maxArea };
		return answer;
    }
    
	public static void dfs(int[][] picture, int y, int x) {
		visited[y][x] = true;
		cnt++;
		int color = picture[y][x];
		
		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			
			if(!outOfIndex(newY, newX) && !visited[newY][newX] && picture[newY][newX] == color) {
				dfs(picture, newY, newX);
			}
		}
	}

	public static boolean outOfIndex(int y, int x) {
		if(y < 0 || x < 0 || y >= limitY || x >= limitX) {
			return true;
		}
		return false;
	}
}
