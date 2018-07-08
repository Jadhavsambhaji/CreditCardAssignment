package com.mycard.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.mycard.model.CreditCard;


@RunWith(MockitoJUnitRunner.class)
public class CreditCardServiceImplTest {
	
	@InjectMocks
	private CreditCardServiceImpl cardServiceImpl;
	CreditCard card;
	
	private static long VALID_CREDIT_CARD_NUMBER = 4872383159493094L;
	private static long INVALID_CREDIT_CARD_NUMBER = 1212121212;
	
	@Before
	public void setup() {
		cardServiceImpl = new CreditCardServiceImpl();
		card = createCreditCard();
	}
	
	
	@Test
	public void shouldReturnCreditCardDetailsIfNumberIsValid() {
		CreditCard actualCreditCard = cardServiceImpl.findCreditCardByNumber(VALID_CREDIT_CARD_NUMBER);
		assertNotNull(actualCreditCard);
		assertEquals(card.getExpirationDate(), actualCreditCard.getExpirationDate());		
	}
	
	@Test
	public void shouldReturnNullIfNumberIsInValid() {
		CreditCard actualCreditCard = cardServiceImpl.findCreditCardByNumber(INVALID_CREDIT_CARD_NUMBER);
		assertNull(actualCreditCard);		
	}
	
	@Test
	public void shouldSaveCreditCardDetails() {
		cardServiceImpl.saveCreditCard(card);
		
	}
	
	@Test
	public void shouldReturnTrueIfCreditCardIsAlreadyExists() {
		assertTrue(cardServiceImpl.isCardExist(card));		
	}
	@Test
	public void shouldReturnFalseIfCreditCardIsNotExists() {
		assertFalse(cardServiceImpl.isCardExist(card));		
	}
	
	
	private CreditCard createCreditCard() {
		CreditCard creditCard = new CreditCard();
		creditCard.setNumber(VALID_CREDIT_CARD_NUMBER);
		creditCard.setType("Master");
		creditCard.setCvv(712);
		creditCard.setExpirationDate("10/2021");
		return creditCard;
	}
	

}
