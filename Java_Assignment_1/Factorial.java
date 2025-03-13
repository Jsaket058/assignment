import java.util.*;

class Factorial {
    // Max value that can be stored in long : 20! = 2,432,902,008,176,640,000
    private static final int MAX = 20;
    private static final long[] fact = new long[MAX + 1];
    static {
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (0-20): ");
        int num = sc.nextInt();
        System.out.println("Factorial: " + factorial(num));
        sc.close();
    }
    
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Factorial not defined for negative numbers");
        if (n > MAX) throw new ArithmeticException("Result too large for long");
        return fact[n];
    }
}
