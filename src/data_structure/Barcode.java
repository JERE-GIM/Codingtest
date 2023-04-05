package data_structure;

public class Barcode {
    public String barcode(int len) {
        return aux("",len);
    }

    public boolean isValid(String str) {
        StringBuilder sb = new StringBuilder(str);
        String reverse = sb.reverse().toString();

        int half = str.length() / 2;
        for (int i = 1; i <= half; i++) {
            if (reverse.substring(0, i).equals(reverse.substring(i, i + i)))
                return false;
        }
        return true;
    }

    public String aux(String str, int len) {
        String chr = "123";

        if (str.length() == len) return str;

        for (int i = 0; i < chr.length(); i++) {
            String currentStr = str + chr.charAt(i);
            if(isValid(currentStr)) {
                String result = aux(currentStr, len);
                if(result != null) return result;
            }
        }
        return null;
    }
}

class Barcode_Test {
    public static void main(String[] args) {
        Barcode b = new Barcode();
//        String output = b.barcode(3);
//        System.out.println(output); // "121"
//
//        output = b.barcode(7);
//        System.out.println(output); // "1213121"
        String output = b.barcode(3);
        System.out.println(output); // "1213121"

//        String output3 = b.barcode(20);
//        System.out.println(output3); // "12131231321231213123"
    }
}
