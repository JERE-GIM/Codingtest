package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baekjoon8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];

        for (int i = 0; i < n; i++){
            s[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(sumOX(s[i]));
        }

    }

    public static int sumOX(String str) {
        int sum = 0;
        int count = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i <str.length(); i++) {
            if(chars[i] == 'O') {
                count++;
            } else if (chars[i] == 'X') {
                count = 0;
            } else return -1;
            sum += count;
        }

        return sum;
    }
}
