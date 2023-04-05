package algorithm_ex;

import java.util.*;

public class Ocean {
    public long ocean(int target, int[] type) {
        int n = type.length;
        long[] dp = new long[target + 1];

        // 초기값 설정
        dp[0] = 1;

        // dp 배열 계산
        // target = 5, 1,2,5
        // i = 0, type[0] = 1, dp[1,1,1,1,1,1]
        // dp[j] = dp[j] + dp[
        for (int i = 0; i < n; i++) {
            for (int j = type[i]; j <= target; j++) {
                dp[j] += dp[j - type[i]];
            }
        }

        return dp[target];


    }
}

class Ocean_Test {
    public static void main(String[] args) {
        Ocean o = new Ocean();
        int output = (int) o.ocean(50, new int[]{10, 20, 50});
        System.out.println(output); // 4

        output = (int) o.ocean(100, new int[]{10, 20, 50});
        System.out.println(output); // 10

        output = (int) o.ocean(30, new int[]{5, 6, 7});
        System.out.println(output); // 4
    }
}