package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon10972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        // 4 3 5 6 2 1
        // 1. 오른쪽에서부터 가장 긴 내림차순 수열을 찾는다.
        // -> 이때 인덱스 i부터 끝까지 내림차순이 되어있으니까 다음 수열 순서는
        // 인덱스 i-1을 기준으로 오름차순으로 정렬이 끝났다는 의미이므로
        // i-1을 그 이후의 숫자 중 i-1보다는 큰 수 중 가장 작은 숫자와 스왑하고
        // i부터 끝까지 뒤집어준다.

        if(next_permutation(arr)) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
        } else System.out.println(-1);
    }

    public static boolean next_permutation(int[] arr) {
        int i = arr.length - 1;

        // 가장 긴 내림차순 수열의 첫번 째 인덱스 i를 찾는다.
        while (i > 0 && arr[i] <= arr[i - 1]) i--;
        // i가 0이라면 처음부터 내림차순이 되어있다는 뜻이므로 마지막 순열이 된다.
        if (i <= 0) return false;

        int j = arr.length - 1;
        // i 이후 인덱스 중에서 arr[i-1]보다 큰 수 중 가장 작은 수를 찾는다.
        while (arr[i - 1] >= arr[j]) j--;

        // 둘의 자리를 스왑
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        // 인덱스 i 이후부터 뒤집는다.
        while (i < j) {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
        return true;
    }
}


