package com.mycard.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.mycard.model.CreditCard;

@Service("creditCardService")
public class CreditCardServiceImpl implements CreditCardService{
     
    private static List<CreditCard> creditCards = new ArrayList<CreditCard>();
     
    static {
    	creditCards= populateDummyCreditCardDetails();
    }

	@Override
	public CreditCard findCreditCardByNumber(long number) {
		 for(CreditCard creditCard : creditCards) {
            if(creditCard.getNumber() == number){
                return creditCard;
	        }
	    }
		return null;
	}

	@Override
	public void saveCreditCard(CreditCard creditCard) {
		creditCards.add(creditCard);		
	}
	
	@Override
	public boolean isCardExist(CreditCard creditCard) {
		 return findCreditCardByNumber(creditCard.getNumber())!=null;
	}
	
	private static List<CreditCard> populateDummyCreditCardDetails() {
		
		createVisaCards();		
		createMasterCards();		
		createAmexCards();	
		createDiscoverCards();	
		
        return creditCards;
    }

	private static void createDiscoverCards() {
		creditCards.add(new CreditCard(6011443014875302L,"Discover","11/2021", 10, 137));
		creditCards.add(new CreditCard(6011812336396702L,"Discover","09/2024", 20, 589));
	}

	private static void createAmexCards() {
		creditCards.add(new CreditCard(376558238780772L,"AMEX","08/2023", 30, 335));
		creditCards.add(new CreditCard(371330087370955L,"AMEX","11/2018", 50, 690));
	}

	private static void createMasterCards() {
		creditCards.add(new CreditCard(5480924856546451L,"Master Card","11/2022", 500, 890));
		creditCards.add(new CreditCard(5214126936411747L,"Master Card","07/2023", 500, 915));
	}

	private static void createVisaCards() {
		creditCards.add(new CreditCard(4872383159493094L,"VISA", "10/2021", 5, 712));
		creditCards.add(new CreditCard(4067822599811279L,"VISA", "04/2021", 10, 847));
	}
	
}
