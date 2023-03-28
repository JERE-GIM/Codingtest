package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1010 {
    private static final int MAX = 30;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[][] dp = new int[MAX + 1][MAX + 1];

        // 배열 초기화
        for (int i = 0; i <= MAX; i++) {
            dp[i][1] = i;
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int j = 2; j <= MAX; j++) {
            for (int k = 1; k < j; k++) {
                dp[j][k] = dp[j - 1][k] + dp[j - 1][k - 1];
            }
        }

        for (int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(dp[j][k]);
        }
    }
}
