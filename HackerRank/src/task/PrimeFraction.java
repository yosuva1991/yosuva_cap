package task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFraction {
	
	
	private static List<Integer> getPrimeFractionList(int number) {
		List<Integer> resultList = new ArrayList<Integer>();
		int limit = number/2;
		Boolean flag = false;
		for(int i=2;i<=limit;i++) {
			if(flag) {
				i=2;
				flag = false;
			}
			Boolean ignore = false;
			if(number%i == 0) {
				if(isPrimeNo(i)) {
					resultList.add(i);
					ignore = true;
				}
			int fraction = number/i;
			if(isPrimeNo(fraction)) {
				resultList.add(fraction);
				break;
			}
			int innerLimit = fraction/2;
			for(int j=2;j<=innerLimit;j++) {
				if(fraction%j==0) {
					flag = true;
					limit = innerLimit;
					number = fraction;
					break;
				}
			}
			if(flag) {
				continue;
			}else {
				if(! ignore)
				resultList.add(fraction);
			}
		 }
		}
		return resultList;
	}
	
	private static Boolean isPrimeNo(int number) {
		Boolean isPrime = true;
		int limit = number/2;
		for(int i=2;i<=limit;i++) {
			if(number%i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//isPrimeNo(9);
		System.out.println(getPrimeFractionList(48));

	}

}
