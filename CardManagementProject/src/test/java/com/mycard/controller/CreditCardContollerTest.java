package com.mycard.controller;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardContollerTest {
	
	private CreditCardContoller creditCardController; 
	
	@Before
	public void setup() {
		creditCardController = new CreditCardContoller();
	}
	
	@Test
	public void shouldGetCreditCardDetaildIfCardNumberAreValid() {
		
	}
	
	@Test
	public void shouldNotReturnCreditCardDetaildIfCardNumberAreInValid() {
		creditCardController.getCreditCardDetails(121212212);
	}


}
