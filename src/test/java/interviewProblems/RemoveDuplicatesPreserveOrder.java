package interviewProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicatesPreserveOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Given an array of integers, remove duplicates while preserving the original insertion
		int n;
		Scanner sc = new Scanner(System.in);  // Create scanner object
		System.out.println("enter no of input values");
		n=Integer.parseInt(sc.nextLine());
		List<Integer> arr=new ArrayList<Integer>();
		
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(sc.nextLine()));
		}
		List<Integer> newArr=new ArrayList<Integer>();
		for(int i:arr) {
			if(!newArr.contains(i)) {
				newArr.add(i);
			}
		}
		System.out.println("Original Array: "+arr);
		System.out.println("Duplicate Array: "+newArr);

	}

}
