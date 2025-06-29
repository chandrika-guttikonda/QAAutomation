package interviewProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		// Given a string, find the first character that does not repeat anywhere in the string.
		Scanner sc = new Scanner(System.in);  // Create scanner object
		System.out.println("enter the string value");
		String str=sc.nextLine();
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(char s:str.toCharArray()) {
			if(map.containsKey(s)) {
				map.put(s,map.get(s)+1);
			}
			else {
				map.put(s, 1);
			}
		}
		System.out.println(map);
		char unique=' ';
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue()==1) {
				unique=entry.getKey();
			}
			
		}
		System.out.println("unique Character: "+unique);

	}

}
