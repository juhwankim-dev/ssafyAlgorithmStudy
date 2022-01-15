package programmers;

public class Week18_2개_이하로_다른_비트 {
	public static long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			long a = numbers[i];

			if (a % 2 == 0) {
				answer[i] = a + 1;
			} else {
				String bin = Long.toBinaryString(a);
				int zeroIdx = bin.lastIndexOf('0');

				String s = "";
				if (zeroIdx == -1) {
					s = "10" + bin.substring(1, bin.length());
				} else {
					s = bin.substring(0, zeroIdx) + "10" + bin.substring(zeroIdx + 2, bin.length());
				}

				answer[i] = Long.parseLong(s, 2);
			}
		}

		return answer;
	}
}
