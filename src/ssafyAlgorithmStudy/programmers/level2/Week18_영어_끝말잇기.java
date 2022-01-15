package programmers;

import java.util.HashSet;

public class Week18_영어_끝말잇기 {
	public static int[] solution(int n, String[] words) {
		HashSet<String> hs = new HashSet<>();
		int[] answer = new int[2];
		char first, last = words[0].charAt(0);

		for (int i = 0; i < words.length; i++) {
			first = words[i].charAt(0);

			if (hs.contains(words[i]) || first != last) {
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			}

			hs.add(words[i]);
			last = words[i].charAt(words[i].length() - 1);
		}

		return answer;
	}
}
