package interviewProblems;

import java.util.Scanner;

public class FactorialIterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);

		int rev=0;
		System.out.println("enter value of n: ");
		int n=sc.nextInt();
		int res=1,i=1;

		while(i<=n) {
			res=res*i;
			i+=1;
		}
		System.out.println("Factorial: "+res);
	}

}
