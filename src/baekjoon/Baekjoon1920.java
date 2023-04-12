package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
        bs(nArr, mArr);
    }

    public static void bs(int[] nArr, int[] mArr) {
        outer:
        for (int i : mArr) {
            int left = 0;
            int mid = nArr.length / 2;
            int right = nArr.length - 1;

            while (right - left != 1) {
                if (nArr[mid] == i || nArr[left] == i || nArr[right] == i) {
                    System.out.println(1);
                    continue outer;
                }

                if (i > nArr[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
                mid = (left + right) / 2;
            }
            System.out.println(0);
        }
    }
}
