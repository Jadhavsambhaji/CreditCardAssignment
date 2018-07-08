package com.mycard.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.mycard.model.CreditCard;
import com.mycard.service.CreditCardServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardContollerTest {
	
	@InjectMocks
	private CreditCardContoller creditCardController; 
	
	@Mock
	private CreditCardServiceImpl cardServiceImpl;
	
	private static long VALID_CREDIT_CARD_NUMBER = 4872383159493094L;
	private static long INVALID_CREDIT_CARD_NUMBER = 1212121212;
	
	@Before
	public void setup() {
		creditCardController = new CreditCardContoller();
	}
	
	@Test
	public void shouldGetCreditCardDetaildIfCardNumberAreValid() {
		CreditCard creditCard = createCreditCard();
		Mockito.when(cardServiceImpl.findCreditCardByNumber(Mockito.anyLong())).thenReturn(creditCard);
		ResponseEntity<CreditCard> entity = creditCardController.getCreditCardDetails(VALID_CREDIT_CARD_NUMBER);
		CreditCard actualValue = entity.getBody();
		assertEquals(200, entity.getStatusCodeValue());
		assertNotNull(actualValue);
		assertEquals(creditCard.getNumber(), actualValue.getNumber());
	}


	@Test
	public void shouldNotReturnCreditCardDetaildIfCardNumberAreInValid() {
		ResponseEntity<CreditCard> entity = creditCardController.getCreditCardDetails(INVALID_CREDIT_CARD_NUMBER);
		assertEquals(400, entity.getStatusCodeValue());
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
