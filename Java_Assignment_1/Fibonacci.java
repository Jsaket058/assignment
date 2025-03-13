import java.util.*;
class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the limit: ");
        int limit = sc.nextInt();
        int a = 0, b = 1;

        System.out.print("Fibonacci sequence: " + a);
        while (b <= limit) {
            System.out.print(" " + b);
            int next = a + b;
            a = b;
            b = next;
        }
        sc.close();
    }
}
