package programmers;

import java.util.ArrayList;

public class Week20_모음_사전 {
	static ArrayList<String> list = new ArrayList<>();
	static char[] word = { 'A', 'E', 'I', 'O', 'U' };

	public static int solution(String word) {
		DFS(new StringBuilder(), 0);
		return list.indexOf(word);
	}

	public static void DFS(StringBuilder sb, int len) {
		for (int i = 0; i < 5; i++) {
			sb.append(word[i]);
			list.add(sb.toString());

			if (len < 4) {
				DFS(sb, len + 1);
			}

			sb.deleteCharAt(len);
		}
	}
}
