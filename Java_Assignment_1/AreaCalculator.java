import java.util.*;

class AreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type shape: circle, rectangle, or triangle");
        String shape = sc.next().toLowerCase();
        switch (shape) {
            case "circle":
                System.out.print("Enter radius: ");
                double r = sc.nextDouble();
                System.out.println("Area: " + (Math.PI * r * r));
                break;
            case "rectangle":
                System.out.print("Enter length and width: ");
                double l = sc.nextDouble(), w = sc.nextDouble();
                System.out.println("Area: " + (l * w));
                break;
            case "triangle":
                System.out.print("Enter base and height: ");
                double b = sc.nextDouble(), h = sc.nextDouble();
                System.out.println("Area: " + (0.5 * b * h));
                break;
            default:
                System.out.println("Invalid shape");
        }
        sc.close();
    }
}