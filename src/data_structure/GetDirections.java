package data_structure;

import java.util.*;

public class GetDirections {
    public boolean getDirections(int[][] matrix, int from, int to) {
        // 재귀로 구현
        // 배열 복사
//        int[][] currentMatrix = new int[matrix.length][];
//        for (int i = 0; i < currentMatrix.length; i++) {
//            currentMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
//        }
        // 배열 복사 스트림으로 구현
        int[][] currentMatrix = Arrays.stream(matrix)
                .map(int[]::clone)
                .toArray(int[][]::new);


        // 종료조건
        if (from == to) return true;

        //재귀함수
        for (int i = 0; i < currentMatrix[from].length; i++) {
            if(currentMatrix[from][i] == 1) {
                currentMatrix[from][i] = 0;
                if(getDirections(currentMatrix,i,to) == true) return true;
            }
        }
        return false;

//        // Stack으로 구현
//        boolean[] visited = new boolean[matrix.length];
//        Stack<Integer> stack = new Stack<>();
//        stack.push(from);
//
//        while (!stack.isEmpty()) {
//            int curr = stack.pop();
//
//            if (visited[curr]) continue;
//
//            visited[curr] = true;
//            for (int i = 0; i < matrix[curr].length; i++) {
//                // 1->2->1 이런 루프가 있을 때 true를 리턴하고 종료
//                if (from == to) {
//                    if (matrix[curr][from] == 1) return true;
//                }
//                if (matrix[curr][i] == 1 && !visited[i]) {
//                    if (i == to) return true;
//                    stack.push(i);
//                }
//            }
//        }
//        return false;
    }
}

class GetDirections_Test {
    public static void main(String[] args) {
        GetDirections g = new GetDirections();
        boolean result = g.getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2
        );
        System.out.println(result); // true
        result = g.getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {1, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                0
        );
        System.out.println(result); // true
        result = g.getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                4
        );
        System.out.println(result); // false
    }
}
