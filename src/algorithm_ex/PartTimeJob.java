package algorithm_ex;

import java.util.Comparator;

enum Coins {
    FIVE_HUNDRED(500), ONE_HUNDRED(100), FIFTY(50),
    TEN(10), FIVE(5), ONE(1);

    private final int value;

    Coins(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
public class PartTimeJob {
    public int partTimeJob(int k) {
        // k를 500원으로 나눈 값을 count에 더하고
        // 위 결과의 나머지를 100원으로 나눈 값을 count에 더하고
        // 위 결과의 나머지를 50원으로 나눈 값을 count에 더하고
        // 위 결과의 나머지를 10원으로 나눈 값을 count에 더하고
        // 위 결과의 나머지를 5원으로 나눈 값을 count에 더하고
        // 위 결과의 나머지를 count에 더하고
        // count 리턴
        int count = 0;

        for (Coins coin : Coins.values()) {
            count += k / coin.getValue();
            k %= coin.getValue();
        }

//        count += k / 500;
//        count += k % 500 / 100;
//        count += k % 500 % 100 / 50;
//        count += k % 500 % 100 % 50 / 10;
//        count += k % 500 % 100 % 50 % 10 / 5;
//        count += k % 500 % 100 % 50 % 10 % 5;

        return count;
    }
}

class PartTimeJob_Test {
    public static void main(String[] args) {
        PartTimeJob p = new PartTimeJob();
        // 4000원을 받았을 때 500원짜리 동전 8개를 반환합니다.
        int output1 = p.partTimeJob(4000);
        System.out.println(output1); // --> 8

        // 4972원을 받았을 때 500원짜리 동전 9개,
        // 100원짜리 동전 4개, 50원짜리 동전 1개,
        // 10원짜리 동전 2개, 1원짜리 동전 2개, 총 18개를 반환합니다.
        int output2 = p.partTimeJob(4972);
        System.out.println(output2); // --> 18
    }
}
