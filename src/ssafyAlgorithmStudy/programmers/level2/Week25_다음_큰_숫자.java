package programmers;

public class Week25_����_ū_���� {
	static final int MAX = 1000000;

	public static void main(String[] args) {
		System.out.println(solution(78));
	}

	public static int solution(int n) {
		int bitCnt = Integer.bitCount(n);

		while(bitCnt != Integer.bitCount(++n)) {}

		return n;
	}
}
