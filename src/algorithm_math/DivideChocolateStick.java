package algorithm_math;

import java.util.*;

public class DivideChocolateStick {
    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // A, B(자연수, A>B) 이고 A%B=R 일 때,
        // gcd(A,B) = gcd(B,R)
        int gcd = gcd(M, N);

        ArrayList<Integer> cd = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(gcd); i++) {
            if (gcd % i == 0) {
                cd.add(i);
                cd.add(gcd / i);
            }
            if (i == Math.sqrt(gcd)) cd.remove(new Integer(i));
        }
        Collections.sort(cd);

        ArrayList<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < cd.size(); i++) {
            Integer[] cdComb = new Integer[3];
            cdComb[0] = cd.get(i);
            cdComb[1] = M / cd.get(i);
            cdComb[2] = N / cd.get(i);
            result.add(cdComb);
        }

        return result;
    }

    public int gcd(int M, int N) {
        if (M % N == 0)
            return N;
        else {
            return gcd(N, M % N);
        }

    }
}

class DivideChocolateStick_Test {
    public static void main(String[] args) {
        DivideChocolateStick d = new DivideChocolateStick();
        ArrayList<Integer[]> output = d.divideChocolateStick(20, 10);
        for (Integer[] arr : output) {
            System.out.println(Arrays.toString(arr));
        } // [[1, 4, 8], [2, 2, 4], [4, 1, 2]]
    }
}
