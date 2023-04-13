package daily_coding;

import java.util.*;

public class RemoveExtremes {
    public String[] removeExtremes(String[] arr) {
        if (arr.length == 0) return null;
        // ['where', 'is', 'the', 'longest', 'word']를 입력받은 경우, ['where', 'the', 'word']를 리턴해야 합니다
        // {"a", "c", "b", "def"} -> [a, c]
        int max = Arrays.stream(arr)
                .mapToInt(String::length)
                .max()
                .getAsInt();
        int min = Arrays.stream(arr)
                .mapToInt(String::length)
                .min()
                .getAsInt();

        Stack<String> maxStack = new Stack<>();
        Stack<String> minStack = new Stack<>();
        for (String s : arr) {
            if (s.length() == max)
                maxStack.push(s);
            else if (s.length() == min)
                minStack.push(s);
        }

        List<String> list = new LinkedList<>(Arrays.asList(arr));
        list.remove(list.lastIndexOf(maxStack.pop()));
        list.remove(list.lastIndexOf(minStack.pop()));

        return list.toArray(String[]::new);
    }
}

class RemoveRxtremes_Test {
    public static void main(String[] args) {
        RemoveExtremes r = new RemoveExtremes();
        String[] output = r.removeExtremes(new String[]{"a", "c", "b", "a", "def"});
        System.out.println(Arrays.toString(output));

        output = r.removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(Arrays.toString(output));
    }
}
