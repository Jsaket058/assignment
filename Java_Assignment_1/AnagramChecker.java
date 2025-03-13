import java.util.*;

public class AnagramChecker {
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st String : ");
        String str1 = sc.next();
        System.out.print("Enter 2nd String : ");
        String str2 = sc.next();
        System.out.println("Are they anagrams ??? " + areAnagrams(str1, str2));
        sc.close();
    }
}
