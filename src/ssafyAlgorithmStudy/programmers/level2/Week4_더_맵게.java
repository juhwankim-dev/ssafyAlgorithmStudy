package ssafyAlgorithmStudy.programmers.level2;

import java.util.*;

public class Week4_더_맵게 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int cnt = 0;
		
		for(int s : scoville)
			pq.add(s);
		
		while(pq.peek() < K) {
			if(pq.size() == 1)
				return -1;
			
			int first = pq.poll();
			int second = pq.poll();
			int newFood = first + (second * 2);
			pq.add(newFood);
			cnt++;
		}
		
		return cnt;
	}
}
