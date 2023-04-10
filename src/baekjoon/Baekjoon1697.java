package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // s-1 s+1 s*2 중 하나를 선택해서 end까지 가는 최소의 횟수
        // 5-10-9-18-17 -> 4번
        System.out.println(bfs(start, end));
    }

    public static int bfs(int s, int e) {
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr == e) return visited[curr];
            int[] arr = {curr - 1, curr + 1, curr * 2};

            for (int i = 0; i < arr.length; i++) {
                if(arr[i] < 0 || arr[i] > 100000) continue;
                if(visited[arr[i]] != 0) continue;
                visited[arr[i]] = visited[curr] + 1;
                queue.offer(arr[i]);
            }
        }
        return -1;
    }
}