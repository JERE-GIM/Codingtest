package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 무인도여행 {
    String[][] island;
    boolean[][] visited;
    int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] solution(String[] maps) {
        // 2차원 배열로 만든다.
        island = new String[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                island[i][j] = maps[i].charAt(j) + "";
            }
        }

        visited = new boolean[island.length][island[0].length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (!island[i][j].equals("X") && !visited[i][j]) {
                    list.add(dfs(i, j, Integer.parseInt(island[i][j])));
                }
            }
        }
        if (list.isEmpty())
            return new int[]{-1};
        else
            return list.stream().sorted().mapToInt(d -> d).toArray();
    }

    public int dfs(int row, int cal, int sum) {
        visited[row][cal] = true;

        for (int i = 0; i < 4; i++) {
            int nr = row + D[i][0];
            int nc = cal + D[i][1];

            if (nr < 0 || nc < 0 || nr >= island.length || nc >= island[0].length) continue;
            if (visited[nr][nc]) continue;
            if (island[nr][nc].equals("X")) continue;

            sum += Integer.parseInt(island[nr][nc]);
            sum = dfs(nr, nc, sum);
        }
        return sum;
    }
}

class 무인도여행_Test {
    public static void main(String[] args) {
        무인도여행 m = new 무인도여행();
        int[] output = m.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"});
        System.out.println(Arrays.toString(output));
    }
}
