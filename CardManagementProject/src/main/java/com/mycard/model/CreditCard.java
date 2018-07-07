package com.mycard.model;

public class CreditCard {
	
	private long  number;
    
    private String type;
     
    private String expirationDate;
    
    private int cvv;
    
    private int totalNumberofCards;
     
    
	public CreditCard() { }


	public CreditCard(long number, String type, String expirationDate, int totalNumberofCards, int cvv) {
		super();
		this.number = number;
		this.type = type;
		this.expirationDate = expirationDate;
		this.totalNumberofCards = totalNumberofCards;
		this.cvv = cvv;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getTotalNumberofCards() {
		return totalNumberofCards;
	}

	public void setTotalNumberofCards(int totalNumberofCards) {
		this.totalNumberofCards = totalNumberofCards;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
    
	
}
