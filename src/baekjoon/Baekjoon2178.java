package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon2178 {
    static final int MAX = 100;
    static int N;
    static int M;
    static int[][] miro = new int[MAX][MAX];
    static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Point {
        int row, col, dist;

        public Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(bfs(N, M));
    }

    public static int bfs(int N, int M) {
        boolean[][] visited = new boolean[N][M];
        Queue<Point> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Point(0, 0, 1));

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (curr.row == N - 1 && curr.col == M - 1) return curr.dist;

            for (int i = 0; i < 4; i++) {
                int nr = curr.row + D[i][0];
                int nc = curr.col + D[i][1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (miro[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                queue.offer(new Point(nr, nc, curr.dist + 1));
            }
        }
        return -1;
    }
}
