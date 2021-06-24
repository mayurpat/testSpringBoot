package com.example.demo.utility;

public class FizzBuzzUtility {
	
	

	public static void main(String args[]) {
		
		FizzBuzzUtility fb= new FizzBuzzUtility();
		
		for (int i=1;i<=100;i++) {
			System.out.println(fb.checkFizzBuzz(i));
		}
		
	}
	
	
	public String checkFizzBuzz(Integer i) {
		
		if(i==null) {
			return "Null";
		}
		if(i%3 == 0 & i%5==0) {
			return "FIZZBUZZ";
		}else if(i%5 == 0) {
			return "BUZZ";
		}else if(i%3 == 0) {
			return "FIZZ";
		}else {
			return String.valueOf(i);
		}
		
	}

}
