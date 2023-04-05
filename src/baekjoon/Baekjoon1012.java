package baekjoon;

import java.io.*;

public class Baekjoon1012 {
    static int N, M, K;
    static int[][] farm;
    static boolean[][] visited;
    static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);
            farm = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < K; j++) {
                String[] edge = br.readLine().split(" ");
                farm[Integer.parseInt(edge[0])][Integer.parseInt(edge[1])] = 1;
            }
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (farm[j][k] == 1 && !visited[j][k]) {
                        cnt++;
                        dfs(j, k);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nr = x + D[i][0];
            int nc = y + D[i][1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (visited[nr][nc]) continue;
            if (farm[nr][nc] == 0) continue;
            dfs(nr, nc);
        }
    }
}