package swea;

import java.io.*;
import java.util.*;

public class Week8_4727_견우와_직녀 {
   static int N, M;
   static int[][] map = new int[11][11];
   static int[][][] best = new int[2][11][11];
   static int[] dy = { -1, 1, 0, 0 };
   static int[] dx = { 0, 0, -1, 1 };
   static Queue<Node> q = new LinkedList<>();

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      int testCase = Integer.valueOf(br.readLine());

      for (int tc = 1; tc <= testCase; tc++) {
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
            }
         }

         q.clear();

         for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
               best[0][i][j] = Integer.MAX_VALUE;
               best[1][i][j] = Integer.MAX_VALUE;
            }
         }

         int ret = run();
         System.out.println("#" + tc + " " + ret);
      }
   }

   public static int getNextLev(int nowLev, int ny, int nx, int T) {
      if (T == 1)
         return nowLev + 1;
      if (T == 0)
         T = M;
      return ((nowLev / T) + 1) * T;
   }

   public static int run() {
      q.add(new Node(0, 0, 0, 0));

      while (!q.isEmpty()) {
         Node now = q.poll();

         for (int t = 0; t < 4; t++) {
            int ny = now.y + dy[t];
            int nx = now.x + dx[t];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N)
               continue;
            if (now.isUsedM == 1 && map[ny][nx] == 0)
               continue;

            // 새로운 다리를 사용할지 결정
            int nextUsedM = now.isUsedM;
            if (now.isUsedM == 0 && map[ny][nx] == 0)
               nextUsedM = 1;

            // 절벽 연속 2개 방지
            if (map[now.y][now.x] != 1 && map[ny][nx] != 1)
               continue;

            // 시간 계산하기
            int nextLev = getNextLev(now.lev, ny, nx, map[ny][nx]);

            // 최적인지 확인
            if (best[nextUsedM][ny][nx] <= nextLev)
               continue;
            best[nextUsedM][ny][nx] = nextLev;
            q.add(new Node(ny, nx, nextUsedM, nextLev));
         }
      }

      int mini = best[0][N - 1][N - 1];
      if (mini > best[1][N - 1][N - 1])
         mini = best[1][N - 1][N - 1];
      return mini;
   }
}

class Node {
   int y, x;
   int isUsedM;
   int lev;

   public Node(int y, int x, int isUsedM, int lev) {
      this.y = y;
      this.x = x;
      this.isUsedM = isUsedM;
      this.lev = lev;
   }
}