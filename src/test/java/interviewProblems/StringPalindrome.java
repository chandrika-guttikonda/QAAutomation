package interviewProblems;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		System.out.println("enter value of String: ");
		String n=sc.nextLine();

		String rev="";
		String s=n;
		for(int i=n.length()-1;i>=0;i--) {
			rev+=n.charAt(i);
		}
		
		if(s.equals(rev)) {
			System.out.println(rev+" is a palindrome");
		}
		else {
			System.out.println(rev+" is not a palindrome");
		}
	}

}
