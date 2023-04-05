package data_structure;

import java.util.*;

public class ConnectedVertices {
    public int connectedVertices(int[][] edges) {
        int count = 0;
        // 2차원 배열 edges는 간선을 표시하는 배열이다.
        // edges를 1차원 IntStream으로 만들고 중복 제거해서 node의 개수를 구한다.
        int node = (int) Arrays.stream(edges)
                .flatMapToInt(Arrays::stream)
                .distinct()
                .count();
        // node 크기의 2차원 배열 graph 생성
        int[][] graph = new int[node][node];
        // edges에 표현된 간선을 graph에 1로 변경
        // 무향이기 때문에 [2][0] 이면 [0][2]도 1로 변경
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
        }

        // 각 노드들을 방문했다는 표시를 하는 visited 배열 생성
        boolean[] visited = new boolean[node];
        // BFS를 하기 위한 Queue 생성
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < edges.length; i++) {
            // edges[i][0]부터 탐색을 하는데 이미 방문했다면 continue
            if(visited[edges[i][0]]) continue;
            // 첫 시작 노드는 queue에 미리 저장하고 while문 시작
            visited[edges[i][0]] = true;
            queue.offer(edges[i][0]);
            // queue가 비어있을 때는 노드에 인접한 노드가 없다는 뜻이므로 이때 while문을
            // 끝내고 count++
            while (!queue.isEmpty()) {
                int curr = queue.remove();

                for (int j = 0; j < node; j++) {
                    if (!visited[j] && graph[curr][j] != 0) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
            count++;
        }
        return count;
    }
}
class ConnectedVertices_Test {
    public static void main(String[] args) {
        ConnectedVertices c = new ConnectedVertices();
        int result = c.connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {4, 5},
        });
        System.out.println(result); // 3

        int result2 = c.connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5},
        });
        System.out.println(result2); // 2
    }
}
