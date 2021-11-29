package programmers;

import java.util.*;

public class Week14_예상_대진표 {	
	public static int solution(int n, int a, int b) {
		int cnt = 0;
		
		while(a != b) {
			cnt ++;
			a = (a + 1) / 2;
			b = (b + 1) / 2;
		}
		
		return cnt;
	}
}
