package com.mycard.service;

import com.mycard.model.CreditCard;

public interface CreditCardService  {
	
	CreditCard findCreditCardByNumber(long number);
	
	void saveCreditCard(CreditCard creditCard);

	boolean isCardExist(CreditCard creditCard);

}
