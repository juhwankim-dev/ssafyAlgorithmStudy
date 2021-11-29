package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Week14_순위_검색 {
	static HashMap<String, ArrayList<Integer>> hs = new HashMap<>();;
	static ArrayList<Integer> in;

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };

		String[] query = { "- and backend and senior and - 150", "- and - and - and chicken 100",
				"- and - and - and - 150" };

		System.out.println(Arrays.toString(solution(info, query)));
	}

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		// info 모든 경우의 수를 map에 저장
		for (int i = 0; i < info.length; i++) {
			dfs("", 0, info[i].split(" "));
		}

		// map에 저장된 경우의 수를 for문으로 돌면서
		List<String> list = new ArrayList<>(hs.keySet());
		for (int i = 0; i < list.size(); i++) {
			List<Integer> scoreList = hs.get(list.get(i)); // 해당 경우의 수에 포함되는 점수들을
			Collections.sort(scoreList); // 정렬한다.
		}

		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] str = query[i].split(" ");
			int score = Integer.parseInt(str[1]);

			answer[i] = search(str[0], score);
		}
		return answer;
	}

	static void dfs(String str, int depth, String[] info) {
		if (depth == 4) {
			if (!hs.containsKey(str)) {
				in = new ArrayList<>();
				in.add(Integer.parseInt(info[4]));
				hs.put(str, in);
			} else {
				hs.get(str).add(Integer.parseInt(info[4]));
			}
			return;
		}
		dfs(str + "-", depth + 1, info);
		dfs(str + info[depth], depth + 1, info);
	}

	// 이분 탐색
	static int search(String str, int score) {
		if (!hs.containsKey(str)) return 0;
		
		List<Integer> scoreList = hs.get(str);
		int start = 0, end = scoreList.size() - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (scoreList.get(mid) < score) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return scoreList.size() - start;
	}
}

/*
 	public static int[] solution(String[] info, String[] query) {
		StringTokenizer st;
		String[][] applicant = new String[info.length][5];
		for (int i = 0; i < info.length; i++) {
			st = new StringTokenizer(info[i]);

			for (int j = 0; j < 5; j++) {
				applicant[i][j] = st.nextToken();
			}
		}

		int[] result = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			String[] q = query[i].split(" and | ");
			
			List<String[]> list = Arrays.asList(applicant);
			for (j = 0; j < 4; j++) {
				if (!q[j].equals("-")) {
					list = list.stream().filter(l -> l[j].equals(q[j])).collect(Collectors.toList());
				}
			}
			list = list.stream().filter(l -> Integer.parseInt(l[4]) >= Integer.parseInt(q[4]))
					.collect(Collectors.toList());

			result[i] = list.size();
		}

		return result;
	}
 */
