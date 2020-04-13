package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Anagram {
	
	
	public static List<String> funWithAnagrams(String[] input){
		ArrayList<Integer> removedIndex = new ArrayList<Integer>();
		List<String> resultList = new ArrayList<String>();
		for(int i=0;i<input.length;i++) {
			String word = input[i];
			List<String> letters = Arrays.asList(word.split(""));
			for(int j=i+1;j<input.length;j++) {
				String nextWord = input[j];
				List<String> nextLetters = Arrays.asList(nextWord.split(""));
				if(letters.size() == nextLetters.size() && letters.containsAll(nextLetters) 
						&& !removedIndex.contains(j)) {
					removedIndex.add(j);
				}
			}
		}
		for(int j=0;j<input.length;j++) {
			if(!removedIndex.contains(j)) {
				resultList.add(input[j]);
			}
		}
		Collections.sort(resultList);
		return resultList;
		
	}
	
	public static void main(String[] args) {
		//System.out.println("Please Enter number of Words");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] input = new String[n];
		if(n<=1000) {
			//System.out.println("Please Enter Words");
			for(int i=0;i<n;i++) {
				Scanner scanner = new Scanner(System.in);
			    String string = scanner.next();
			    if(string.length() <1000 && string.length() != 0){
			    	input[i] = string;
			    }else {
			    	//System.out.println("Word length should be less than or equal 1000");
			    	i--;
			    }
			    //scanner.close();
			}
		}
		sc.close();
		
		List<String> funWithAnagrams = funWithAnagrams(input);
		funWithAnagrams.stream().forEach(i -> System.out.println(i));
		
	}

}
