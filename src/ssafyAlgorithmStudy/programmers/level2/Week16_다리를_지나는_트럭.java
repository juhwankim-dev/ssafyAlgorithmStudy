package programmers;

import java.util.*;

public class Week16_�ٸ���_������_Ʈ�� {

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
        int weightSum = 0; // ���� �ٸ��� �ִ� ������ ���� ��
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
        	answer++; // 1������
        }while(!queue.isEmpty()); // ť�� �� ������� ����
        
        return answer;
    }
}
