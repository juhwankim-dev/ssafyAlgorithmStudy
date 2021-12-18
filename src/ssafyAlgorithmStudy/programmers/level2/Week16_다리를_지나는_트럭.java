package programmers;

import java.util.*;

public class Week16_다리를_지나는_트럭 {

	public static void main(String[] args) {
		int[] t = {7, 4, 5, 6};
		System.out.println(solution(2, 10, t));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<bridge_length; i++) {
        	queue.add(0);
        }
        
        int i = 0;
        int weightSum = 0; // 현재 다리에 있는 차들의 무게 합
        int size = truck_weights.length;
        do {
        	weightSum -= queue.poll();
        	if(i < size) {
        		if(weightSum + truck_weights[i] <= weight) {
        			queue.add(truck_weights[i]);
        			weightSum += truck_weights[i++];
        		} else {
        			queue.add(0);
        		}
        	}
        	answer++; // 1초증가
        }while(!queue.isEmpty()); // 큐가 다 비워질때 까지
        
        return answer;
    }
}
