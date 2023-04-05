package algorithm_ex;

public class BoardGame {
    public Integer boardGame(int[][] board, String operation) {
        // (0,0) 시작
        // 2차원 배열 board (0,1로 구성)
        // U,D,R,L : 상하좌우
        // operation으로 움직여서 만난 1의 합을 리턴
        // 갔던 곳 또 갈 수 있고 점수 재획득 가능
        int sum = 0;
        int raw = 0;
        int col = 0;

        while (operation.length() != 0) {
            switch (operation.charAt(0)) {
                case 'U':
                    raw--;
                    if(raw < 0) return null;
                    if(board[raw][col] == 1) sum++;
                    break;
                case 'D':
                    raw++;
                    if(raw > board.length) return null;
                    if(board[raw][col] == 1) sum++;
                    break;
                case 'R':
                    col++;
                    if(col > board[0].length) return null;
                    if(board[raw][col] == 1) sum++;
                    break;
                case 'L':
                    col--;
                    if(col < 0) return null;
                    if(board[raw][col] == 1) sum++;
                    break;
            }
            if(operation.length() == 1) break;
            operation = operation.substring(1);
        }
        return sum;
    }
}

class BoardGame_Test {
    public static void main(String[] args) {
        BoardGame b = new BoardGame();
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        int output1 = b.boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        int output2 = b.boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int output3 = b.boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }
}