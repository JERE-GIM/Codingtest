package algorithm_math;

import java.util.*;

// 조합 문제
public class BoringBlackjack {
    int count = 0;
    public int boringBlackjack(int[] cards) {
        // cards 배열의 요소들을 3개씩 조합해서 나오는 숫자들 중 소수의 개수 리턴
        combination(cards, new boolean[cards.length],0,0,3);
        return count;
    }

    public void combination(int[] cards, boolean[] visited, int start, int depth, int r) {
        // 종료조건
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < cards.length; i++) {
                if(visited[i]) {
                    sum += cards[i];
                }
            }
            if(isPrime(sum)) count++;
            return;
        }

        // 재귀
        for (int i = start; i < cards.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(cards, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i ++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

class BoringBlackjack_Test {
    public static void main(String[] args) {
        BoringBlackjack b = new BoringBlackjack();
        int output = b.boringBlackjack(new int[]{1, 2, 3, 4});
        System.out.println(output); // 1

        output = b.boringBlackjack(new int[]{2, 3, 4, 8, 13});
        System.out.println(output); // 4
    }
}
