package algorithm_math;

import java.util.*;
import java.util.stream.Collectors;
// 순열 문제
public class NewChickenRecipe {
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // String.valueOf로 String[] 배열로 만들고 chars()로 각 문자를 스트림으로 변환
        // 각 문자가 0 이면 count하고 이게 3보다 작은 요소만 sorted()로 정렬해서 newArr에 저장
        int[] newArr = Arrays.stream(stuffArr)
                .filter(num -> String.valueOf(num).chars().filter(ch -> ch == '0').count() < 3)
                .sorted()
                .toArray();

        // 0이 3개 이상 들어간 요소를 제거한 배열의 길이가 choiceNum보다 작을 경우
        if (newArr.length < choiceNum) return null;
        // 종료조건
        if (choiceNum == 1) {
            ArrayList<Integer[]> list = new ArrayList<>();
            for (int i : newArr) {
                list.add(new Integer[]{i});
            }
            return list;
        }

        ArrayList<Integer[]> list = newChickenRecipe(newArr, choiceNum - 1);
        // 기존 list에서 각 요소에 남은 요소를 더해서 새로 만든 newList
        ArrayList<Integer[]> newList = new ArrayList<>();

        for (Integer[] element : list) {
            // newArr list로 변환
            List<Integer> visitedArr = Arrays.stream(newArr)
                    .boxed()
                    .collect(Collectors.toList());
            // 기존 list의 element 배열에 있던 요소를 제거(중복 방지)
            for (int i = 0; i < element.length; i++) {
                visitedArr.remove(element[i]);
            }
            // 기존 element 배열에 visitedArr 요소들을 각각 뒤에 추가한 newElement
            for (int i = 0; i < visitedArr.size(); i++) {
                Integer[] newElement = new Integer[element.length + 1];
                System.arraycopy(element, 0, newElement, 0, element.length);
                newElement[element.length] = visitedArr.get(i);
                newList.add(newElement);
            }
        }
        return newList;
    }
}

class NewChickenRecipe_Test {
    public static void main(String[] args) {
        NewChickenRecipe n = new NewChickenRecipe();
        ArrayList<Integer[]> output = n.newChickenRecipe(new int[]{10, 1, 1100, 1111}, 2);
        for (Integer[] arr : output) {
            System.out.println(Arrays.toString(arr));
        }
/*
    [
        [1, 10], [1, 1100], [1, 1111],
        [10, 1], [10, 1100], [10, 1111],
        [1100, 1], [1100, 10], [1100, 1111],
        [1111, 1], [1111, 10], [1111, 1100]
    ]
*/
    }
}
