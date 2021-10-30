package programmers;

import java.util.*;

public class Week10_튜플_첫번째_풀이 {
	static final int MAX = 100001;
	public static int[] solution(String s) {
		StringTokenizer st = new StringTokenizer(s, "{|}|,");

		int[] count = new int[MAX];
		while (st.hasMoreTokens()) {
			count[Integer.parseInt(st.nextToken())]++;
		}

		int eleCnt = 0;
		int[] order = new int[MAX];
		for (int i = 1; i < MAX; i++) {
			if (count[i] > 0) {
				order[count[i]] = i;
				eleCnt++;
			}
		}

		int[] result = new int[eleCnt];
		eleCnt--;
		for (int i = 1; i < MAX; i++) {
			if (order[i] > 0) {
				result[eleCnt--] = order[i];

				if (eleCnt < 0) {
					break;
				}
			}
		}

		return result;
	}
}
