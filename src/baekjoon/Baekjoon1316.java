package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Baekjoon1316 {
    public static void main(String[] args) throws IOException {
        // ccazzzzbb, kin 그룹 단어
        // aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int cnt = 0;
        outer:
        for (int i = 0; i < testCase; i++) {
            // 입력받은 문자열을 쪼갠다.
            String[] strArr = br.readLine().split("");
            // 중복을 제거해서 list에 저장한다.
            ArrayList<String> list = new ArrayList<>(Arrays.asList(Arrays.stream(strArr).distinct().toArray(String[]::new)));
            // list = cazb
            // strArr = ccaczzbb
            int idx = 0;
            for (int j = 0; j < list.size(); j++) {
                for (int k = idx; k < strArr.length; k++) {
                    if (!list.get(j).equals(strArr[k])) {
                        // 같이 않는데 그 문자의 인덱스가 j보다 작다는건 이미 검사했던 문자란 뜻이므로
                        // 이때 cnt++를 하지 않고 다음 testCase로 넘어간다.
                        if(list.indexOf(strArr[k]) < j) {
                            continue outer;
                        }
                        idx = k;
                        break;
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
