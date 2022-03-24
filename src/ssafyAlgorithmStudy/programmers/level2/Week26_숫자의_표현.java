package programmers;

public class Week26_숫자의_표현 {

	public static void main(String[] args) {
		System.out.println(solution(15));
	}

	public static int solution(int n) {
		int num = n, cnt = 0;

		for (int i = (n + 1) / 2; i >= 0 && num >= n; i--) {
			num = getCloseNumber(n, 0, i);

			if (num == n) {
				cnt++;
			}
		}

		return cnt + 1;
	}

	public static int getCloseNumber(int n, int sum, int desc) {
		if (sum >= n || desc == 0) {
			return sum;
		}

		return getCloseNumber(n, sum + desc, desc - 1);
	}
}
