package baekjoon;

import java.io.*;

public class Baekjoon11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] tile = new int[input + 1];
        tile[0] = 0;
        tile[1] = 1;
        tile[2] = 2;
        for (int i = 3; i <= input; i++) {
            tile[i] = (tile[i-1] + tile[i-2]) % 10007;
        }
        System.out.println(tile[input]);
    }
}