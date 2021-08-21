package ssafyAlgorithmStudy.programmers.level2;

public class Week1_124_나라의_숫자 {

	public static void main(String[] args) {
		
	}

    public String solution(int n) {
    	String[] num = {"4", "1", "2"};
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
        	sb.append(num[n % 3]);
        	n = (n - 1) / 3;
        }

        return sb.reverse().toString();
    }
}
