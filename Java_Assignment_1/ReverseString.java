import java.util.*; 
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any word : ");
        String input = sc.next();
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reverse2(input));
        sc.close();
    }

    public static String reverse1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverse2(String str) {
        char[] charArray = str.toCharArray();
        int left = 0, right = charArray.length - 1;
        
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            
            left++;
            right--;
        }
        return new String(charArray);
    }
}
