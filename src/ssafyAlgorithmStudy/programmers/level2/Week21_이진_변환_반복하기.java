package programmers;

public class Week21_이진_변환_반복하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int zeros = 0;
        int transCnt = 0;
        
        while(!s.equals("1")) {
        	int len = s.length();
        	s = s.replace("0", "");
        	zeros += len - s.length();
        	
        	s = Integer.toBinaryString(s.length());
        	transCnt++;
        }
        
        answer[0] = transCnt;
        answer[1] = zeros;
        return answer;
    }
}
