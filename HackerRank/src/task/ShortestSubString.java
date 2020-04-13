package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShortestSubString {
	
	public static int shortestSubstring(String s) {
		
		List<String> letters = Arrays.asList(s.split(""));
		List<String> uniqueLetters = letters.stream().distinct().collect(Collectors.toList());
		List<String> subStringList = new ArrayList<String>();
		int length = letters.size();
		for(int i=0;i<letters.size();i++) {
			subStringList.add(letters.get(i));
			if(subStringList.containsAll(uniqueLetters)) {
				if(subStringList.size()<length) {
					length = subStringList.size();
					subStringList.clear();
				}else {
					subStringList.clear();
				}
			}
		}
		return length;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		System.out.println(shortestSubstring(inputString));
		scanner.close();
	}

}
