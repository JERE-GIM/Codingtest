package data_structure;

import java.util.*;

public class ReverseArr {
    public int[] reverseArr(int[] arr) {
        if (arr.length == 0) return new int[]{};

        int[] head = Arrays.copyOfRange(arr, arr.length - 1, arr.length);
        int[] tail = reverseArr(Arrays.copyOfRange(arr, 0, arr.length - 1));

        List<int[]> list = new ArrayList<>();
        list.add(head);
        list.add(tail);

        return list.stream().flatMapToInt(Arrays::stream).toArray();
//
//        int[] reverse = new int[head.length + tail.length];
//
//        System.arraycopy(head,0,reverse,0,head.length);
//        System.arraycopy(tail,0,reverse,head.length,tail.length);
//
//        return reverse;
    }
}

class ReverseArr_Test {
    public static void main(String[] args) {
        ReverseArr r = new ReverseArr();

        int[] output = r.reverseArr(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(output));
    }
}
