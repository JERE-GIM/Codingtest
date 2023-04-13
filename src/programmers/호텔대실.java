package programmers;

import java.util.*;

public class 호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];
        // 방을 현재 사용하고 있는지 여부 체크
        boolean[] room = new boolean[time.length];
        // "15:10"에서 : 제거하고 int 형으로 변환 -> 1510
        for (int i = 0; i < time.length; i++) {
            time[i][0] = Integer.parseInt(book_time[i][0].replace(":", ""));
            time[i][1] = Integer.parseInt(book_time[i][1].replace(":", ""));
        }
        // 시작시간순서대로 정렬
        Arrays.sort(time, (o1, o2) -> o1[0] - o2[0]);

        answer++;
        room[0] = true;
        outer:
        for (int i = 1; i < time.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 1555 + 10 = 1565 -> 1605, n % 100 >= 60 -> n + 40
                int etime = time[j][1] + 10;
                if (etime % 100 >= 60) {
                    etime += 40;
                }
                // 새 방을 쓰면 room[i]는 true
                // 시작시간이 전의 종료시간 + 10 보다 크거나 같다면 그 방은 현재 비어있다는 의미
                // 비어있는 방에 새 예약시간이 들어가고 true로 바꾸고 전에 있던 예약은 false
                if (time[i][0] >= etime && room[j]) {
                    room[i] = true;
                    room[j] = false;
                    continue outer;
                }
            }
            answer++;
            // 새 방을 쓰면 room[i]는 true
            room[i] = true;
        }
        return answer;
    }
}


class 호텔대실_Test {
    public static void main(String[] args) {
        호텔대실 h = new 호텔대실();
        int output = h.solution(new String[][]{
                {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"},
                {"14:10", "19:20"}, {"18:20", "21:20"}});
        System.out.println(output); // 3

        output = h.solution(new String[][]{
                {"09:10", "10:10"}, {"10:20", "12:20"}});
        System.out.println(output); // 1

        output = h.solution(new String[][]{
                {"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}});
        System.out.println(output); // 3
    }
}
