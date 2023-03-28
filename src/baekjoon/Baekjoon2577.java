package baekjoon;

import java.util.Scanner;

public class Baekjoon2577 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        String result = String.valueOf(n1 * n2 * n3);

        for (int i = 0; i < 10; i++) {
            char ch_i =(char)(i + '0');
            System.out.println(countChar(result, ch_i));
        }
    }

    public static int countChar(String result, char ch) {
        int count = 0;

        for (int i = 0; i <result.length(); i++) {
            if(result.charAt(i) == ch) count++;
        }
        return count;
    }
}
