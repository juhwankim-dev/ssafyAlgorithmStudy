package swea;

import java.util.*;

public class Week9_뉴스_클러스터링 {
	public static int solution(String str1, String str2) {
		HashMap<String, Integer> A = new HashMap<>();
		HashMap<String, Integer> B = new HashMap<>();
		MultipleSets(A, str1.toUpperCase());
		MultipleSets(B, str2.toUpperCase());

		return (int) Math.floor(Jaccard(A, B) * 65536);
	}

	// 다중집합 만들기
	public static void MultipleSets(HashMap<String, Integer> map, String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			char ch1 = str.charAt(i);
			char ch2 = str.charAt(i + 1);
			if (Character.isAlphabetic(ch1) && Character.isAlphabetic(ch2)) {
				String key = ch1 + "" + ch2;
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
		}
	}

	// 자카드
	public static double Jaccard(HashMap<String, Integer> A, HashMap<String, Integer> B) {
		double intersection = 0, union = 0;

		for (String key : A.keySet()) {
			if (B.containsKey(key)) {
				intersection += Math.min(A.get(key), B.get(key));
				union += Math.max(A.get(key), B.get(key));
			} else {
				union += A.get(key);
			}
		}

		for (String key : B.keySet()) {
			if (!A.containsKey(key)) {
				union += B.get(key);
			}
		}

		return (union == 0) ? 1 : intersection / union;
	}
}
