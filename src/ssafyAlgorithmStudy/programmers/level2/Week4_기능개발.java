package ssafyAlgorithmStudy.programmers.level2;

import java.util.*;

public class Week4_기능개발 {

	public static void main(String[] args) {
		
	}

	public Queue<Integer> solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<>();
		int day, idx = 0;
		
		while(idx < progresses.length) {
			day = (int)Math.ceil((100 - progresses[idx]) / (double)speeds[idx]);
			int cnt = 0;
			
			while(idx < progresses.length && progresses[idx] + (speeds[idx] * day) >= 100) {
				cnt++;
				idx++;
			}
			
			queue.add(cnt);
		}
		
		return queue;
	}
}
