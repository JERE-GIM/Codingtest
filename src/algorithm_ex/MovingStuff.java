package algorithm_ex;

import java.util.*;
import java.util.stream.Collectors;

public class MovingStuff {
    public int movingStuff(int[] stuff, int limit) {
        // 짐의 무게를 담은 배열 stuff와 박스의 무게 제한 limit가 매개변수로 주어질 때,
        // 모든 짐을 옮기기 위해 필요한 박스 개수의 최소값을 return

        int count = 0;
        // 요소 삭제를 쉽게하기 위해서 List로 변환
        List<Integer> list = Arrays.stream(stuff)
                .boxed()
                .collect(Collectors.toList());
        // 2개 짐의 합을 저장할 리스트
        List<Integer> sum = new ArrayList<>();

        // list의 사이즈가 1이하가 되면 종료
        while(list.size() > 1) {
            // 한 사이클 돌고 sum 리스트 초기화
            sum.clear();
            // list의 0번 + 1번 ~ list.size까지 더한 값들 sum에 저장
            for (int i = 1; i < list.size(); i++) {
                sum.add(list.get(0) + list.get(i));
            }
            // sum 요소 중 limit를 넘지 않으면서 가장 큰 값을 max에 저장
            // 모든 요소가 limit를 넘는다면 list.get(0) 저장
            int max = sum.stream()
                    .filter(num -> num <= limit)
                    .mapToInt(d -> d)
                    .max().orElse(list.get(0));
            // max가 list.get(0)이라면 한번에 2개를 옮길 수 없다는 뜻이므로 0번 째 요소만 제거, count++
            if(max == list.get(0)) {
                list.remove(0);
                count++;
            } else { // 2개를 옮기는데 2개의 무게 합이 limit에 최대한 가까운 값을 찾아 그 2개를 list에서 제거
                list.remove(Integer.valueOf(max - list.get(0)));
                list.remove(0);
                count++;
            }
        }
        // while문이 끝나면 list의 사이즈는 0,1 인데 0이면 count를 리턴하지만
        // 1이라면 아직 짐이 1개 남아있다는 의미이므로 count++ 해주고 count 리턴
        if(list.size() == 1) count++;
        return count;
    }
}

class MovingStuff_Test {
    public static void main(String[] args) {
        MovingStuff m = new MovingStuff();
//        int output = m.movingStuff(new int[]{70, 50, 80, 50}, 100);
//        System.out.println(output); // 3
//
//        output = m.movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
//        System.out.println(output); // 4

        int output = m.movingStuff(new int[]{42, 25, 60, 73, 103, 167}, 187);
        System.out.println(output); // 4
    }
}
