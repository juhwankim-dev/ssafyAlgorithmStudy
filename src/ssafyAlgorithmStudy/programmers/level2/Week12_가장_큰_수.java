package programmers;

import java.util.*;

public class Week12_가장_큰_수 {
	public String solution(int[] numbers) {
		String[] _numbers = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			_numbers[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(_numbers, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		if (_numbers[0].equals("0")) {
			return "0";
		}

		StringBuilder sb = new StringBuilder();
		for (String n : _numbers) {
			sb.append(n);
		}

		return sb.toString();
	}
}
