import java.util.*;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        System.out.print("Enter scale (C for Celsius, F for Fahrenheit): ");
        char scale = sc.next().charAt(0);

        if (scale != 'C' && scale != 'c' && scale != 'F' && scale != 'f') {
            System.out.println("Invalid scale! Use 'C' for Celsius or 'F' for Fahrenheit.");
        } else {
            double convertedTemp = convertTemperature(temp, scale);
            System.out.printf("Converted Temperature: %.2f %s\n", convertedTemp, 
                (scale == 'C' || scale == 'c') ? "Fahrenheit" : "Celsius");
        }

        sc.close();
    }
    public static double convertTemperature(double temp, char scale) {
        return (scale == 'C' || scale == 'c') 
            ? (temp * 9 / 5) + 32  // Celsius to Fahrenheit
            : (temp - 32) * 5 / 9;  // Fahrenheit to Celsius
    }
}
