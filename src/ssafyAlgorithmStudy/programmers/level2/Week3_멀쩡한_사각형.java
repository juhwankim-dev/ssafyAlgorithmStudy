package ssafyAlgorithmStudy.programmers.level2;

public class Week3_멀쩡한_사각형 {

	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}

	public static long solution(long w, long h) {
		double slope = w / (double)h;
		long cnt = 0;
		int x = 0;

		for (int y = 0; y < w; y++) {
			while(x < h) {
				if(y < (int)(slope * x)) {
					cnt += h - x;
					break;
				}
				x++;
			}
		}
		
		return cnt * 2;
	}
}
