package daily_coding;

import java.util.*;

public class ReadVertically {
    public String readVertically(String[] arr) {
        StringBuilder sb = new StringBuilder();
        //arr 배열에서 가장 긴 문자열의 길이 max에 저장
        int max = Arrays.stream(arr)
                .mapToInt(String::length)
                .max()
                .orElse(0);

        for (int i = 0; i < max; i++) {
            for (String s : arr) {
                if (s.length() <= i) continue;
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

class ReadVertically_Test {
    public static void main(String[] args) {
        ReadVertically r = new ReadVertically();

        String output = r.readVertically(new String[]{"new", "hello", "aa"});
        System.out.println(output);

        output = r.readVertically(new String[]{"aa", "bbb", "cccc"});
        System.out.println(output);
    }
}
