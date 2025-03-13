import java.util.*;
class EvenAndOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println((num ^ 1) == (num + 1) ? "Even" : "Odd");
        sc.close();
    }
}
