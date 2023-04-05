package data_structure;

public class Factorial {
    public int factorial(int num) {
        int result;

        // base case
        if (num == 1) return result = 1;

        // recursive case
        result = num * factorial(num - 1);
        return result;
    }
}

class Factorial_Test {
    public static void main(String[] args) {
        Factorial f = new Factorial();

        int output = f.factorial(3);
        System.out.println(output);
    }
}
