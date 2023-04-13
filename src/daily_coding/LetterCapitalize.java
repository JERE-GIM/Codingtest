package daily_coding;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCapitalize {
    public String letterCapitalize(String str) {
        // 문자열을 입력받아 문자열을 구성하는 각 단어의 첫 글자가 대문자인 문자열을 리턴
        // 스트림으로 구현
        return Arrays.stream(str.split(" "))
                .map(word -> { if(!word.equals("")) {
                    return Character.toUpperCase(word.charAt(0)) + word.substring(1);
                } else
                    return word;
                }).collect(Collectors.joining(" "));

        // for 문으로 구현
//        if (str.length() == 0) return str;
//
//        String[] strs = str.split(" ");
//
//        for (int i = 0; i < strs.length; i++) {
//            if (!strs[i].isEmpty())
//                strs[i] = String.valueOf(strs[i].charAt(0)).toUpperCase() + strs[i].substring(1);
//        }
//
//        return String.join(" ", strs);
    }
}

class LetterCapitalize_Test {
    public static void main(String[] args) {
        LetterCapitalize l = new LetterCapitalize();
        String output1 = l.letterCapitalize("hello world");
        System.out.println(output1); // "Hello World"
        String output2 = l.letterCapitalize("java  is good");
        System.out.println(output2); // "Java  Is Good"
    }
}
