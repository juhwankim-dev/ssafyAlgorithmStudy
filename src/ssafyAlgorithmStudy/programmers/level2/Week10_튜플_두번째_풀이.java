package programmers;

import java.util.*;
import java.util.Map.Entry;

public class Week10_튜플_두번째_풀이 {
	public static Queue<Integer> solution(String s) {
		StringTokenizer st = new StringTokenizer(s, "{|}|,");
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		while(st.hasMoreTokens()) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		// Map.Entry 리스트 작성
		List<Entry<Integer, Integer>> entryList = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		
		// 비교함수 Comparator를 사용하여 내림 차순으로 정렬
		Collections.sort(entryList, new Comparator<Entry<Integer, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
				// 내림 차순으로 정렬
				return obj2.getValue() - obj1.getValue();
			}
		});
		
		Queue<Integer> queue = new LinkedList<>();
		for(Map.Entry<Integer, Integer> entry : entryList){
			queue.add(entry.getKey());
		}

		return queue;
	}
}
