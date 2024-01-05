package BankingLibrary;

import java.util.ArrayList;
public class Bank {
	private String bankName;
	private ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public Bank(String bankName) {
		this.bankName = bankName;
	}
	
	private void addAccount(BankAccount acc) {
		accounts.add(acc);
	}
	
	public void addAccount(String name, double balance, double maxWithLimit, String memNID) {
		SavingsAccount sa = new SavingsAccount(name, balance, maxWithLimit, memNID);
		addAccount(sa);
		String acc = sa.getAccountNumber();
		System.out.print("Your savings account number: "+acc);
	}
	
	public void addAccount(String name, double balance, String memNID, String license) {
		CurrentAccount ca = new CurrentAccount(name, balance, memNID, license);
		addAccount(ca);
		String acc = ca.getAccountNumber();
		System.out.print("Your current account number: "+acc);
	}
	
	public void addAccount(String name, double balance, String nid, String stdID, String institution) {
		StudentAccount sta = new StudentAccount(name, nid, balance, stdID, institution);
		addAccount(sta);
		String acc = sta.getAccountNumber();
		System.out.println("Your student account number: "+acc);
	}
	
	private BankAccount findAccount(String accNum) {
		for(int i=0; i<accounts.size(); i++) {
			if(accounts.get(i).getAccountNumber().equals(accNum)) {
				return accounts.get(i);
			}
		}
		return null;
	}
	
	public void deposit(String accountNum, double amt) {
		BankAccount b = findAccount(accountNum);
		if(b != null) {
			b.deposit(amt);
		}
		
		else {
			System.out.println("Account not found");
		}
	}
	
	public void withdraw(String accountNum, double amt) {
		BankAccount b = findAccount(accountNum);
		if(b == null) {
			System.out.println("Account not found");
		}
		else {
			b.withdraw(amt);
		}
	}
	
	public void transfer(String fromAccNum, String toAccNum, double amt) {
		BankAccount fa = findAccount(fromAccNum);
		BankAccount ta = findAccount(toAccNum);
		if(fa != null && ta != null) {
			fa.withdraw(amt, "Transferred to "+ta.getAccountNumber());
			if(fa instanceof SavingsAccount && ((SavingsAccount) fa).getMaxWithLimit()>amt) {
				ta.deposit(amt, "Received from "+fa.getAccountNumber());
			}
			else if(fa instanceof CurrentAccount) {
				ta.deposit(amt, "Received from "+fa.getAccountNumber());
			}
			else if(fa instanceof StudentAccount && ((StudentAccount) fa).getMaxWithLimit()>amt) {
				ta.deposit(amt, "Received from "+fa.getAccountNumber());
			}
				
		}
		else {
			if(fa == null) {
				System.out.println("From account not found");
			}
			else if(ta == null) {
				System.out.println("To account not found");
			}
			else {
				System.out.println("None of these accounts are found");
			}
		}
	}
	
	public double getBalance(String accountNum) {
		BankAccount b = findAccount(accountNum);
		if(b != null) {
			if(b instanceof CurrentAccount) {
				return b.getAccountBalance();
			}
			else if(b instanceof SavingsAccount){
				return ((SavingsAccount)b).getNetBalance();
			}
			else {
				return ((StudentAccount)b).getNetBalance();
			}
		}
		else {
			System.out.println("Account not found");
		}
		return 0;
	}
	
	public ArrayList<BankAccount> getAccounts() {
		return accounts;
	}
	
	public ArrayList<BankAccount> getAccounts(String type) {
		
		ArrayList<BankAccount> bna = new ArrayList<>();
		if(type.equalsIgnoreCase("Savings")) {
			for(BankAccount b: accounts) {
				if(b instanceof SavingsAccount) {
					bna.add(b);
					}
				}
			}
		else if(type.equalsIgnoreCase("Current")) {
			for(int i=0; i<accounts.size(); i++) {
				if(accounts.get(i) instanceof CurrentAccount) {
					bna.add(accounts.get(i));
					}
				}
			}
		else if(type.equalsIgnoreCase("Student")) {
			for(int i=0; i<accounts.size(); i++) {
				if(accounts.get(i) instanceof StudentAccount) {
					bna.add(accounts.get(i));
					}
				}
			}
		return bna;
		}
	
	public ArrayList<Transaction> getAccTransactions(String accountNum) {
		BankAccount b = findAccount(accountNum);
		if(b != null) {
			return b.getTransactions();
		}
		return null;
	}
	
	public ArrayList<BankAccount> findAccounts(String memberNID) {
		ArrayList<BankAccount> bna = new ArrayList<>();
		for(BankAccount bk: accounts) {
			if(bk.getMemberNID().equals(memberNID)) {
				bna.add(bk);
			}
		}
		return bna;
	}
	
	public BankAccount findAccount(String memberNid, String accountNumber) {
		for(BankAccount b: accounts) {
			if(b.getMemberNID().equals(memberNid) && b.getAccountNumber().equals(accountNumber)) {
				return b;
			}
		}
		return null;
	}
	
	ArrayList<Transaction> getAccTransaction(String memberNid, String accountNum) {
		BankAccount b = findAccount(memberNid, accountNum);
		if(b != null) {
			return b.getTransactions();
		}
		return null;
	}
	
	public String getAccountSummary(String accountNum) {
		BankAccount b = findAccount(accountNum);
		return b.toString();
	}
	
	public String getListOfAccounts() {
		String s = accounts.get(0).toString();
		for(int i=1; i<accounts.size(); i++) {
			BankAccount b = accounts.get(i);
			
			
			s = s + "\n" + b.toString();
			
		}
		return s;
	}
}

