package baekjoon;

import java.io.*;

public class Baekjoon10974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        permutation(new int[input], new boolean[input], 0, input);
    }

    public static void permutation(int[] output, boolean[] visited, int depth, int input) {
        //종료조건
        if (depth == input) {
            for (int i = 0; i < input; i++) {
                if (visited[i])
                    System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        //재귀
        for (int i = 0; i < input; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i + 1;
                permutation(output, visited, depth + 1, input);
                visited[i] = false;
            }
        }
    }
}
