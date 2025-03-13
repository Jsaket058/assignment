import java.util.*;

public class Pattern{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of rows for the triangle:");
		int n = sc.nextInt();
	    System.out.println("Pattern for triangle with "+n+" rows");
		trianglePattern(n);
		System.out.print("Enter no. of rows for the square:");
		int m = sc.nextInt();
		squarePattern(m);
        sc.close();
	}
	static void trianglePattern(int n){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i + 1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
    static void squarePattern(int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==0||j==0||i==n-1||j==n-1)System.out.print("* ");
				else System.out.print("  ");
			}
			System.out.println();
		}
	}
}
