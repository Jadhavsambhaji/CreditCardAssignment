package com.mycard.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycard.model.CreditCard;
import com.mycard.service.CreditCardService;
import com.mycard.validation.CardValidation;

@RestController
public class CreditCardContoller {
	
	@Autowired
	CreditCardService creditCardService;
	
	@RequestMapping(value = "/creditCard/{number}", method = RequestMethod.GET)
    public ResponseEntity<CreditCard> getCreditCardDetails(@PathVariable("number") long number) {
		
		if(!CardValidation.isValidCreditCardNumber(number)) {
			 return new ResponseEntity<CreditCard>(HttpStatus.BAD_REQUEST);			
		} 
		
		CreditCard  creditCard = creditCardService.findCreditCardByNumber(number);
		return new ResponseEntity<CreditCard>(creditCard, HttpStatus.OK);
    }	
	
	 @RequestMapping(value = "/creditCard", method = RequestMethod.POST)
	    public ResponseEntity<Void> createCreditCard(@RequestBody CreditCard creditCard) {
			
			if(CardValidation.isValidCreditCardNumber(creditCard.getNumber())) {
				if (creditCardService.isCardExist(creditCard)) {
		            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		        } 				
				creditCard.setExpirationDate(getTodaysExpirationDate());
		        creditCardService.saveCreditCard(creditCard);		 
		        HttpHeaders headers = new HttpHeaders();
		        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			} 
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);	        
	    }

	private String  getTodaysExpirationDate() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH)+1 + "/" + cal.get(Calendar.YEAR);
	}	
}
