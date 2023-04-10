package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon12865 {
    static ArrayList<Integer> list = new ArrayList<>();
    static int wSum, vSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        // 물품의 수
        int N = Integer.parseInt(input[0]);
        // 버틸 수 있는 무게
        int K = Integer.parseInt(input[1]);

        // 각 물품의 무게
        int[] W = new int[N];
        // 각 물품의 가치
        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            String[] WV = br.readLine().split(" ");
            W[i] = Integer.parseInt(WV[0]);
            V[i] = Integer.parseInt(WV[1]);
        }
        // 무게를 넘지 않는 조합 중 최대의 가치를 출력
        // 무게가 K가 안넘을때까지 가치를 더하고 그 가치를 list에 저장하고 list의 최대값을 출력
        boolean[] visited = new boolean[N];

    }

    public static void dp(int K, int[] W, int[] V, boolean[] visited, int wSum, int vSum) {
        if(wSum > K) {
            return;
        }


        for(int i = 0; i < W.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                wSum += W[i];
                vSum += V[i];
                dp(K, W, V, visited, wSum, vSum);
                visited[i] = false;
            }
        }
    }
}
