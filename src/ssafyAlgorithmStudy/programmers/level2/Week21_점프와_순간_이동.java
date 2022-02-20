package programmers;

public class Week21_점프와_순간_이동 {
    public int solution(int n) {
    	return Integer.toBinaryString(n).replace("0", "").length();
    }
}
