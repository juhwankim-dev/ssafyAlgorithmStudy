package programmers;

public class Week26_�ִ񰪰�_�ּڰ� {
	public String solution(String s) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		String[] numbers = s.split(" ");
		for (String number : numbers) {
			int n = Integer.parseInt(number);

			max = Math.max(max, n);
			min = Math.min(min, n);
		}

		return min + " " + max;
	}
}
