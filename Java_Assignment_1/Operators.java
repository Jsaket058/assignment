import java.util.*;

public class Operators{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("\n--- Arithmetic Operators ---");
        System.out.println("Addition (a + b)        : " + (a + b));
        System.out.println("Subtraction (a - b)     : " + (a - b));
        System.out.println("Multiplication (a * b)  : " + (a * b));
        System.out.println("Division (a / b)        : " + (a / b));  
        System.out.println("Modulus (a % b)         : " + (a % b));  

        System.out.println("\n--- Relational Operators ---");
        System.out.println("a == b  : " + (a == b)); 
        System.out.println("a != b  : " + (a != b)); 
        System.out.println("a > b   : " + (a > b));  
        System.out.println("a < b   : " + (a < b));  
        System.out.println("a >= b  : " + (a >= b)); 
        System.out.println("a <= b  : " + (a <= b)); 

        
        boolean cond1 = (a > 0 && b > 0);
        boolean cond2 = (a > 0 || b > 0);
        boolean cond3 = !(a > 0);        

        System.out.println("\n--- Logical Operators ---");
        System.out.println("a > 0 AND b > 0 (&&) : " + cond1);
        System.out.println("a > 0 OR b > 0 (||)  : " + cond2);
        System.out.println("NOT (a > 0) (!)     : " + cond3);

        sc.close();
    }
}
