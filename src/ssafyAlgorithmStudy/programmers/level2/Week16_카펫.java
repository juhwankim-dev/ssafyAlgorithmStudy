package programmers;

public class Week16_Ä«Æê {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i = 1; i <= yellow; i++) {
            if(yellow % i == 0) {
                int brownCnt = (i * 2) + (yellow / i * 2) + 4;
                if(brown == brownCnt) {
                    answer[0] = yellow / i + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }
        return answer;
    }
}
