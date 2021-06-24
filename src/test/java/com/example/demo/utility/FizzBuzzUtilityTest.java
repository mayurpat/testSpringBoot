package com.example.demo.utility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



public class FizzBuzzUtilityTest {
	FizzBuzzUtility fb = new FizzBuzzUtility();
	
	@Test
	public void testFizz() {
		String result ="";
		assertEquals("FIZZ", fb.checkFizzBuzz(3));
	}

}
