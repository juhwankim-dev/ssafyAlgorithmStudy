package swea;

import java.io.*;
import java.util.*;

public class Week8_4311_오래된_스마트폰 {
   private static int best[]; // 숫자를 만들기 위한 최소 터치 횟수
   private static int used[]; 
   private static int nums[]; // 누를 수 있는 숫자 목록
   private static ArrayList<Character> opers; // 사칙연산 목록
   private static int targetNum; // 만들고 싶은 숫자
   
   private static int combi[]; // 나올 수 있는 조합들
   private static int combCnt; // 나올 수 있는 조합의 개수
   private static int combNumCnt[]; // 그 조합이 몇번의 터치가 필요한지 카운트
   private static int combiUsed[]; // 나올 수 있는 조합인지 체크
   
   private static int N; // 누를 수 있는 숫자 개수
   private static int O; // 사칙연산 개수
   private static int M; // 가능한 터치 횟수

   private static final int LIMIT = 1000;
   static char[] sym = { ' ', '+', '-', '*', '/' };
   
   private static void init() {
      Arrays.fill(best, Integer.MAX_VALUE);
      
      for (int i = 0; i < combCnt; i++) {
         int num = combi[i]; // 나올 수 있는 조합을 하나씩 꺼내서...
         best[num] = combNumCnt[i]; // 그 조합을 만드는 최소 횟수(best 횟수)를 저장함.
      }
      
   }
   
   private static int getCalResult(int a, char oper, int b) {
      if (oper == '*') {
         return a * b;
      }
      if (oper == '-') {
         return a - b;
      }
      if (oper == '/') {
         return a / b;
      }
      return a + b;
   }
   
   // touchCnt: now를 만들기 위해 터치한 횟수
   // now: 나올 수 있는 조합의 수
   private static void getMinTouchCnt(int touchCnt, int now) {
      for(char c : opers) {
         for (int i = 0; i < combCnt; i++) {
            int num = combi[i]; // 나올 수 있는 모든 조합을 for문을 돌며 num에 저장
            int nextCnt = touchCnt + combNumCnt[i] + 1; // now를 만들기 위한 터치 수 + num을 만들기 위한 터치 수 + 사칙연산을 누르기 위한 터치 수(+1)
            
            // 나중에 '='도 눌러야 하므로 M - 1보다 카운트가 크면 break
            if (nextCnt > M - 1) {
               break;
            }
            // now 나누기 num 할건데 num이 0이면 안됨
            if (c == '/' && num == 0) {
               continue;
            }
            
            // now와 num을 c라는 연산자를 이용해 계산한 값을 next에 넣음
            int next = getCalResult(now, c, num);
            
            // 범위초과 검사
            if (c == '+' && next >= LIMIT) {
               break;
            }
            if (c == '-' && next < 0) {
               break;
            }
            if (c == '*' && next >= LIMIT) {
               break;
            }
            
            // 
            if (used[next] == 1) {
               continue;
            }
            if (best[next] <= nextCnt) {
               continue;
            }
            
            best[next] = nextCnt; // best 업데이트
            used[next] = 1;
            getMinTouchCnt(nextCnt, next);
            used[next] = 0;
         }
      }
   }
   
   // 숫자로만 조합해서 나올 수 있는 조합의 수인지 찾기
   private static void getCombiDFS(int sum) {
      for (int i = 0; i < N; i++) {
         int next = sum * 10 + nums[i];
         if (next >= LIMIT) {
            continue;
         }
         if (combiUsed[next] == 1) {
            continue;
         }
         combiUsed[next] = 1;
         getCombiDFS(next);
      }
   }
   
   private static void getCombi() {
      for (int i = 0; i < LIMIT; i++) {
         
         // i가 나올 수 있는 조합인지 검사
         if (combiUsed[i] == 0) {
            continue;
         }
         
         // 나올 수 있는 조합이면 조합배열에 차곡차곡 넣는다.
         combi[combCnt] = i;
         
         // 그 조합이 터치가 몇번 필요한지 저장
         if (i < 10) {
            combNumCnt[combCnt] = 1;
         } else if (i < 100) {
            combNumCnt[combCnt] = 2;
         } else if (i < 1000) {
            combNumCnt[combCnt] = 3;
         }
         
         combCnt++;
      }
   }
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int testCase = Integer.valueOf(br.readLine());
      
      for(int tc = 1; tc <= testCase; tc++) {
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken()); // 터치 가능한 숫자들의 개수
         O = Integer.parseInt(st.nextToken()); // 연산자의 개수
         M = Integer.parseInt(st.nextToken()); // 터치 횟수
         
         best = new int[LIMIT];
         used = new int[LIMIT];
         nums = new int[N];
         opers = new ArrayList<>();
         targetNum = 0;
         
         combi = new int[LIMIT];
         combCnt = 0;
         combNumCnt = new int[LIMIT];
         combiUsed = new int[LIMIT];
         
         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
         }
         
         st = new StringTokenizer(br.readLine());
         while (st.hasMoreTokens()) {
            opers.add(sym[Integer.parseInt(st.nextToken())]);
         }

         targetNum = Integer.parseInt(br.readLine());
         combCnt = 0;
         
         getCombiDFS(0);
         getCombi();
         init();
         
         int ret = 0;
         // 사칙연산 없이 숫자를 만들었다면 그것이 best
         if (best[targetNum] != Integer.MAX_VALUE) {
            ret = best[targetNum];
         } else { // 
            for (int i = 0; i < combCnt; i++) {
               getMinTouchCnt(combNumCnt[i], combi[i]);
            }
            ret = best[targetNum] + 1; // '='을 눌러야 하므로 + 1
         }
         
         // targetNum을 만들 수 없다면 -1
         if (best[targetNum] == Integer.MAX_VALUE) ret = -1;
         
         System.out.println("#" + tc + " " + ret);
      }
   }
}