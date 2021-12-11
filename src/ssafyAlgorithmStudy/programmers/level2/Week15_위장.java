package programmers;

import java.util.HashMap;

public class Week15_¿ß¿Â {
	
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hs = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            hs.put(clothes[i][1], hs.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        for (int val : hs.values()){
            answer *= (val + 1);
        }

        return answer - 1;
    }
}
