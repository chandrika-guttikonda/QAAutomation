package interviewProblems;

import java.util.Scanner;

public class FactorialRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);

		int rev=0;
		System.out.println("enter value of n: ");
		int n=sc.nextInt();
		
		System.out.println("Factorial: "+factorial(n));
	}
	
	public static int factorial(int n) {
		if (n < 0) {
            System.out.println("N value is 0");
		}
        if (n == 0 || n == 1) {
            return 1;
        }
		return n*factorial(n-1);
	}

}
