package baekjoon;

import java.util.*;

public class Baekjoon4673 {
    public static void main(String[] args) {
        //  1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
        Set<Integer> set = new HashSet<>();
        // set에 1부터 10000까지 d(n)의 값을 저장시키고
        for (int i = 1; i < 10000; i++) {
            int n = i;
            String[] arr = (n + "").split("");
            int sum = Arrays.stream(arr)
                    .mapToInt(Integer::parseInt)
                    .sum();
            n = n + sum;
            if (n <= 10000) {
                set.add(n);
            }
        }
        List<Integer> manList = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            manList.add(i);
        }
        // 1부터 10000까지 저장된 manList에서 set과 중복된 숫자를 제거
        manList.stream()
                .filter(i -> !set.contains(i))
                .forEach(System.out::println);
    }
}
