package interviewProblems;

import java.util.Scanner;

public class Palindrome {
	public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);

	int rev=0;
	System.out.println("enter value of n: ");
	int n=sc.nextInt();
	int m=n;
	while(n>0) {
		int d=n%10;
		rev=rev*10+d;
		n=n/10;
		
	}
	System.out.println("reversed value: "+rev);
	if(m==rev) {
		System.out.println("N is a palindrome");
	}
	else {
		System.out.println("N is not a palindrome");
	}
	}
}
