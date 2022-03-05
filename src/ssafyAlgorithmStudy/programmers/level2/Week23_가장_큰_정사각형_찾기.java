package programmers;

public class Week23_가장_큰_정사각형_찾기 {
    public int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] arr = new int[row+1][col+1];
    
        for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		arr[i+1][j+1] = board[i][j];
        	}
        }
        
        int answer = 0;
        for(int i=1; i<row+1; i++) {
        	for(int j=1; j<col+1; j++) {
        		if(arr[i][j] != 0) {
            		int squareCnt = getMin(arr[i-1][j-1], arr[i-1][j], arr[i][j-1]) + 1;
            		arr[i][j] = squareCnt;
            		
            		if(squareCnt > answer) {
            			answer = squareCnt;
            		}
        		}
        	}
        }

        return answer*answer;
    }
    
    public int getMin(int a, int b, int c) {
    	return Math.min(a, Math.min(b, c));
    }
}
