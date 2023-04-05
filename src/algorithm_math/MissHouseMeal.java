package algorithm_math;

import java.util.*;

public class MissHouseMeal {

    public ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        ArrayList<String[]> total = new ArrayList<>();
        Arrays.sort(sideDishes);
        total.add(new String[]{});
        // sideDishes.length 4, [] + 4C1 + 4C2 + 4C3 + 4C4
        for (int i = 1; i <= sideDishes.length; i++) {
            total.addAll(combination(sideDishes, new String[]{}, new ArrayList<String[]>(), new boolean[sideDishes.length], 0, 0, i));
        }
        total.sort((o1, o2) -> Arrays.toString(o1).compareTo(Arrays.toString(o2)));
        return total;
    }

    public ArrayList<String[]> combination(String[] sideDishes, String[] bucket, ArrayList<String[]> result, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
            result.add(bucket);
            return result;
        }

        for (int i = start; i < sideDishes.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String[] newArr = Arrays.copyOf(bucket, bucket.length + 1);
                newArr[newArr.length - 1] = sideDishes[i];
                result = combination(sideDishes, newArr, result, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
        return result;
    }
}

class MissHouseMeal_Test {
    public static void main(String[] args) {
        MissHouseMeal m = new MissHouseMeal();
        ArrayList<String[]> output = m.missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});
        for (String[] arr : output) {
            System.out.println(Arrays.toString(arr));
        }
/*
    [ [],
      [eggroll, fishSoup, kimchi],
      [eggroll, fishSoup],
      [eggroll, kimchi],
      [eggroll],
      [fishSoup, kimchi],
      [fishSoup],
      [kimchi]
    ]
*/
    }
}
