package algorithm_math;

import java.util.*;

// 순열 문제
public class NewChickenRecipe2 {
    public ArrayList<Integer[]> newChickenRecipe2(int[] stuffArr, int choiceNum) {
        // String.valueOf로 String[] 배열로 만들고 chars()로 각 문자를 스트림으로 변환
        // 각 문자가 0 이면 count하고 이게 3보다 작은 요소만 sorted()로 정렬해서 newArr에 저장
        int[] freshArr = Arrays.stream(stuffArr)
                .filter(num -> String.valueOf(num).chars().filter(ch -> ch == '0').count() < 3)
                .sorted()
                .toArray();
        return permutation(new ArrayList<>(), new Integer[]{}, freshArr, new boolean[freshArr.length], choiceNum);
    }

    public ArrayList<Integer[]> permutation(ArrayList<Integer[]> outcomes, Integer[] bucket, int[] freshArr, boolean[] visited, int choiceNum) {
        if (choiceNum == 0) {
            outcomes.add(bucket);
            return outcomes;
        }

        for (int i = 0; i < freshArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                Integer[] newBucket = Arrays.copyOf(bucket, bucket.length + 1);
                newBucket[newBucket.length - 1] = freshArr[i];
                permutation(outcomes, newBucket, freshArr, visited, choiceNum - 1);
                visited[i] = false;
            }
        }
        return outcomes;
    }
}

class NewChickenRecipe2_Test {
    public static void main(String[] args) {
        NewChickenRecipe2 n = new NewChickenRecipe2();
        ArrayList<Integer[]> output = n.newChickenRecipe2(new int[]{10, 1, 1100, 1111}, 2);
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
