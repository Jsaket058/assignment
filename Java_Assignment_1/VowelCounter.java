import java.util.*;
public class VowelCounter {
    public static int countVowels(String str) {
        int count = 0;
        // converted to lowercase to handle both cases
        str = str.toLowerCase(); 
        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word : ");
        String input = sc.next();
        System.out.println("Number of vowels: " + countVowels(input));
        sc.close();
    }
}
