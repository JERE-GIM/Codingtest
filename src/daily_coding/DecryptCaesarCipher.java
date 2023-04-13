package daily_coding;

import java.util.stream.*;

public class DecryptCaesarCipher {
    public String decryptCaesarCipher(String str, int secret) {
        return str.chars()
                .map(ch -> (char) (ch == ' ' ? ' ' : ch - secret))
                .map(ch -> ch < 97 ? ch + 26 : ch > 122 ? ch - 26 : ch)
                .map(ch -> (char) ch == ':' ? ' ' : ch)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }
}

class DecryptCaesarCipher_Test {
    public static void main(String[] args) {
        DecryptCaesarCipher d = new DecryptCaesarCipher();

        String output = d.decryptCaesarCipher("khoor zruog", 3);
        System.out.println(output); // "hello world"

        output = d.decryptCaesarCipher("nzop delepd dfaazced jzf", 11);
        System.out.println(output); // "code states supports you"
    }
}
