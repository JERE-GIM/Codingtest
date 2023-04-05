package baekjoon;

import java.io.*;

public class Baekjoon2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        // 3키로 봉지와 5키로 봉지
        // 최소한의 봉지 개수로 옮겨야함
        // 정확하게 N킬로그램을 만들 수 없다면 -1을 출력

        // 4,7 빼고 나머지 정수는 전부 옮길 수 있음
        // 5로 나눈 나머지는 1,2,3,4 중 하나이고
        // 각각의 나머지마다 최소의 개수 계산 가능
        if (input == 4 || input == 7) System.out.println(-1);
        else if (input % 5 == 0) System.out.println(input / 5);
        else if (input % 5 == 1 || input % 5 == 3) {
            System.out.println(input / 5 + 1);
        } else if (input % 5 == 2 || input % 5 == 4) {
            System.out.println(input / 5 + 2);
        } else System.out.println(-1);
    }
}
