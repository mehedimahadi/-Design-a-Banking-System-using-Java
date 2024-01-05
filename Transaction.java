package BankingLibrary;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 

public class Transaction {
	private LocalDateTime transactionTime;
	private double amount;
	private String transactionType;
	
	public Transaction(double amount,String transactionType) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
	    this.transactionTime =LocalDateTime.now();
	    this.amount=amount;
	    this.transactionType=transactionType;
	}

	@Override
	public String toString() {
		return transactionTime+"\t"+amount+"\t\t"+transactionType;
	}
	
}
