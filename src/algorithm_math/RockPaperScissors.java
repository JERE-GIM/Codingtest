package algorithm_math;

import java.util.*;
// 중복순열 문제
public class RockPaperScissors {
    String[] rps = new String[]{"rock", "paper", "scissors"};

    public ArrayList<String[]> rockPaperScissors(int rounds) {
        // 종료조건
        //[rock] [paper] [scissors]
        if (rounds == 1) {
            ArrayList<String[]> list = new ArrayList<>();
            for (String str : rps) {
                list.add(new String[]{str});
            }
            return list;
        }


        ArrayList<String[]> list = rockPaperScissors(rounds - 1);
        // 기존 list에서 각 요소에 rock,paper,scissors를 더해서 새로 만든 newList
        // [rock] [paper] [scissors]
        ArrayList<String[]> newList = new ArrayList<>();
        // [rock]에  [rock,paper] [rock,scissors] 를 각각 추가한 newElement 배열을
        // newList에 저장
        for (String[] element : list) {
            for (int i = 0; i < rps.length; i++) {
                String[] newElement = new String[element.length + 1];
                System.arraycopy(element, 0, newElement, 0, element.length);
                newElement[element.length] = rps[i];
                newList.add(newElement);
            }
        }

        return newList;
    }
}

class RockPaperScissors_Test {
    public static void main(String[] args) {
        RockPaperScissors r = new RockPaperScissors();
        ArrayList<String[]> output = r.rockPaperScissors(5);
        for (String[] arr : output) {
            System.out.println(Arrays.toString(arr));
        }
        /*
    [
      ["rock", "rock", "rock", "rock", "rock"],
      ["rock", "rock", , "rock", "rock", "paper"],
      ["rock", "rock", , "rock", "rock", "scissors"],
      ["rock", "rock", "rock", "paper", "rock"],
      ["rock", "rock", "rock", "paper", "paper"],
      ["rock", "rock", "rock", "paper", "scissors"],
      ["rock", "rock", "rock", "scissors", "rock"],
      // ...etc ...
    ]
  */
    }
}