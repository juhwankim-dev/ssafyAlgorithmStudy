package programmers;

import java.util.*;
import java.util.Map.Entry;

public class Week10_Ʃ��_�ι�°_Ǯ�� {
	public static Queue<Integer> solution(String s) {
		StringTokenizer st = new StringTokenizer(s, "{|}|,");
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		while(st.hasMoreTokens()) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		// Map.Entry ����Ʈ �ۼ�
		List<Entry<Integer, Integer>> entryList = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		
		// ���Լ� Comparator�� ����Ͽ� ���� �������� ����
		Collections.sort(entryList, new Comparator<Entry<Integer, Integer>>() {
			// compare�� ���� ��
			public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
				// ���� �������� ����
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
