package data_structure;

import java.util.*;

public class CreateMatrix {
    public int[][] createMatrix(int[][] edges) {
        int max = Arrays.stream(edges)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(0);
        int[][] result = new int[max + 1][max + 1];
        // 	{0, 3, 0},
        //	{0, 2, 0},
        //	{1, 3, 0},
        //	{2, 1, 0},
        //  {2, 3, 0}
        // [0, 0, 1, 1],
        // [0, 0, 0, 1],
        // [0, 1, 0, 1],
        // [0, 0, 0, 0]
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][2] == 0) {
                result[edges[i][0]][edges[i][1]] = 1;
            } else if (edges[i][2] == 1) {
                result[edges[i][0]][edges[i][1]] = 1;
                result[edges[i][1]][edges[i][0]] = 1;
            }
        }
        return result;
    }
}

class CreateMatrix_Test {
    public static void main(String[] args) {
        CreateMatrix c = new CreateMatrix();
        int[][] output1 = c.createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });

        for (int i = 0; i < output1.length; i++) {
            for (int j = 0; j < output1[i].length; j++) {
                System.out.print(output1[i][j]);
            }
            System.out.println();
        }
    }
}
