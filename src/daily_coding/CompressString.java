package daily_coding;

import java.util.*;

public class CompressString {
    public String compressString(String str) {
        String[] arr = str.split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (arr[i].equals(arr[j])) {
                j++;
                if (j == arr.length) break;
            }

            if (j - i >= 3) sb.append(j - i).append(arr[i]);
            else if (j - i == 2) sb.append(arr[i]).append(arr[i]);
            else sb.append(arr[i]);

            i = j - 1;
        }
        return sb.toString();
    }
}

class CompressString_Test {
    public static void main(String[] args) {
        CompressString c = new CompressString();
        String output = c.compressString("abc");
        System.out.println(output); // --> "abc"

        output = c.compressString("wwwggoppopppp");
        System.out.println(output); // --> "3wggoppo4p"
    }
}
