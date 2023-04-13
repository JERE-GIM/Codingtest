package daily_coding;

import java.util.*;

public class NumberSearch {
    public int numberSearch(String str) {
        if (str.length() == 0) return 0;

        int sum = Arrays.stream(str.split(""))
                .filter(s -> s.matches("-?\\d+"))
                .mapToInt(Integer::parseInt)
                .sum();

        double count = (double)Arrays.stream(str.split(""))
                .filter(s -> !s.matches("-?\\d+"))
                .filter(s->!s.isBlank())
                .count();

        return (int)Math.round(sum / count);
    }
}

class NumberSearch_Test {
    public static void main(String[] args) {
        NumberSearch n = new NumberSearch();
        int output = n.numberSearch("Hello6 ");
        System.out.println(output); // --> 1

        output = n.numberSearch("Hello6 9World 2,");
        System.out.println(output); // --> 2
    }
}
