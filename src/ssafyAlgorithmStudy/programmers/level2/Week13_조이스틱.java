package programmers;

public class Week13_¡∂¿ÃΩ∫∆Ω {
	public int solution(String name) {
		int moves = 0;
		int len = name.length();
		int min = len - 1;
		
		for(int i=0; i<len; i++) {
			moves += getMoves(name.charAt(i));
			
			int idx = i + 1;
			while(idx < len && name.charAt(idx) == 'A') {
				idx++;
			}
			
			min = Math.min(min, (i * 2) + len - idx);
		}
		
		return moves + min;
	}

	public static int getMoves(char target) {
		if (target <= 'N') {
			return target - 'A';
		}

		return Math.abs(target - 'Z') + 1;
	}
}
