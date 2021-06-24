package com.example.demo.utility;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;



public class FizzBuzzUtilityTest {
	
	@Autowired
	FizzBuzzUtility fb ;
	
	@BeforeEach
	public void setUp() {
		fb = new com.example.demo.utility.FizzBuzzUtility();
		
	}
	
	
	@Test
	public void testFizz() {
		assertEquals("FIZZ", fb.checkFizzBuzz(3));
	}
	
	@Test
	public void testBuzz() {
		assertEquals("BUZZ", fb.checkFizzBuzz(5));
	}
	
	
	@Test
	public void testFizzBuzz() {
		assertEquals("FIZZBUZZ", fb.checkFizzBuzz(15));
	}
	
	@Test
	public void testNotFizzBuzz() {
		assertNotEquals("FIZZBUZZ", fb.checkFizzBuzz(1));
	}
	

}
