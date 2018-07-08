package com.mycard.validation;

import static org.powermock.api.easymock.PowerMock.mockStatic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


import org.junit.*;	
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
		
@RunWith(PowerMockRunner.class)
@PrepareForTest(CardValidation.class)
public class CardValidationTest {	
	
	@Mock
	CardValidation cardValidation;
	mockStatic(CardValidation.class);
	
	private static long VALID_CREDIT_CARD_NUMBER = 4872383159493094L;
	private static long INVALID_CREDIT_CARD_NUMBER = 1212121212;
	
	@Before
	public void setup() {
		cardValidation = new CardValidation();
	}
	
	
	@Test
	public void shouldReturnTrueIfNumberIsValid() {
		assertTrue(cardValidation.isValidCreditCardNumber(VALID_CREDIT_CARD_NUMBER));
	}
	
	@Test
	public void shouldReturnFalseIfNumberIsInValid() {
		assertFalse(cardValidation.isValidCreditCardNumber(VALID_CREDIT_CARD_NUMBER));	
	}

}
