package algorithm_ex;

public class BruteForceStringMatch {
    public boolean bruteForceStringMatch(String[] arr, String[] patternArr) {
        // 길이가 n인 전체 문자열과 길이가 m인 문자열 패턴을 포함하는지를 검색
        // 주어진 2개의 배열의 길이를 변수로 정의
        int n = arr.length;
        int m = patternArr.length;

        // n - m범위까지 arr의 배열을 순회
        for (int i = 0; i <= n - m; i++) {
            // arr[i]를 for문 돌기 시작할때마다 j를 0으로 초기화해서 다시 비교 시작
            int j = 0;
            // 검사하면서 같은 문자가 계속 이어질때까지 j++
            while (j < m && patternArr[j].equals(arr[i + j])) {
                j++;
            }
            // 패턴배열의 길이와 j가 같으면 패턴배열을 포함하고 있다는 뜻이므로 return 반환하고 종료
            if (j == m) return true;
        }
        // 가장 바깥 for문 끝까지 검사끝나고 false 반환하며 종료
        return false;
    }
}

class BruteForceStringMatch_Test {
    public static void main(String[] args) {
        BruteForceStringMatch b = new BruteForceStringMatch();
        boolean output = b.bruteForceStringMatch(
                new String[]{"A", "B", "C", "A", "C", "B", "C", "D", "B", "D"},
                new String[]{"C", "D", "B", "D"});
        System.out.println(output);

        output = b.bruteForceStringMatch(
                new String[]{"A", "B", "C", "A", "C", "B", "C", "D", "B", "A"},
                new String[]{"C", "D", "B", "D"});
        System.out.println(output);

    }
}
