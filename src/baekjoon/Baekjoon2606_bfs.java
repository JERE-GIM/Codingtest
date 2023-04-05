package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon2606_bfs {
    static int node, edge, count;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        // 수도코드 작성
        /* 7 -> 컴퓨터의 수
         6 -> 컴퓨터 쌍의 수(간선 개수)
         1 2 -> 연결된 컴퓨터 표시
         2 3
         1 5
         5 2
         5 6
         4 7
         출력 : 1번과 연결된 컴퓨터 수
         서로 연결된 상태를 2차원 배열로 표현하면 다음과 같다
         [0, 1, 0, 0, 1, 0, 0]
         [1, 0, 1, 0, 1, 0, 0]
         [0, 1, 0, 0, 0, 0, 0]
         [0, 0, 0, 0, 0, 0, 1]
         [1, 1, 0, 0, 0, 1, 0]
         [0, 0, 0, 0, 1, 0, 0]
         [0, 0, 0, 1, 0, 0, 0]

         입력된 수를 바탕으로 2차월 배열을 만든다.
         1 2가 입력됐다면 배열의 [0,1] 과 [1,0] 에 1을 표시한다.
         1행부터 탐색해서 1이 있는 곳이 연결되어 있다는 뜻
         1이 있는 행으로 간다 이때 boolean[] visited를 만들어서 탐색한 행은 다시 가지 않는다.
         또 이때 다른 행으로 갈때마다 count++
         그렇게 쭉 탐색하다가 더 이상 탐색이 안되면 더 이상 연결되어 있는 컴퓨터가 없다는 뜻이므로
         이때 count 리턴하고 count 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        for (int i = 0; i < edge; i++) {
            String[] input = br.readLine().split(" ");
            int i1 = Integer.parseInt(input[0]);
            int i2 = Integer.parseInt(input[1]);
            arr[i1][i2] = arr[i2][i1] = 1;
        }
        System.out.println(bfs(arr, new boolean[node + 1]));
    }

    public static int bfs(int[][] arr, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int row = queue.poll();
            if (visited[row]) continue;

            visited[row] = true;
            for (int i = 0; i < arr[row].length; i++) {
                if (arr[row][i] == 1) queue.offer(i);
            }
            count++;
        }
        return count - 1;
    }
}
