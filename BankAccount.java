package BankingLibrary;

import java.util.ArrayList;
import java.util.Random;
 
public class BankAccount {
   private  String memberName, memberNID, accountNumber,transactions;
    private double accountBalance, minimumBalance;
	ArrayList<BankAccount>Transaction = new ArrayList<>();
    
    public BankAccount(String memberName, double accountBalance, double minimumBalance) {
        this.memberName=memberName;
        this.memberNID=memberNID;
        this.accountBalance=accountBalance;
        this.minimumBalance=minimumBalance;
        this.transactions=transactions;
        Random rand = new Random();
        accountNumber="" + rand.nextInt(10) + rand.nextInt(10)+ rand.nextInt(10)+
        		rand.nextInt(10)+ rand.nextInt(10);
    }
    
    public void deposit(double depAmount) {
    	deposit( depAmount, transactions);
    }
    
    protected void deposit(double depAmount, String transactionType) {
    	 if(depAmount>=0) {
             accountBalance+=depAmount;
         }
         else System.out.println("Not enough  deposit amount!");
    	String TY=transactionType;
    }
    
    public void withdraw(double withAmount) {
    	withdraw(withAmount, transactions);
    }
    
    protected void withdraw(double withAmount, String transactionType) {
    	 if(withAmount>=0) {
             if((accountBalance-withAmount)>minimumBalance) {
                 accountBalance-=withAmount;
             }
             else System.out.println("Insufficient Balance!");
         }
         else System.out.println("Not enough withdraw amount!");
    	 String TY=transactionType;
    }
    public void setMemberName(String name) {
		memberName = name;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public String getMemberNID() {
		return memberNID;
	}
	
	public double getMinimumBalance() {
		return minimumBalance;
	}
	
	public ArrayList getTransactions() {
		return Transaction;
	}


	public String toString() {
		 return memberName+" "+accountNumber+" "+accountBalance+" "+minimumBalance;
	}
	
    
}