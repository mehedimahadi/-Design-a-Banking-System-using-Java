package BankingLibrary;

public class SavingsAccount extends BankAccount {
	private double interest=0.05;
	private double maxWithLimit;
	
	public SavingsAccount(String memberName,double accountBalance,double maxwithLimt) {
		super(memberName, accountBalance, 2000);
		this.maxWithLimit=maxWithLimit;
	}
	protected SavingsAccount(String memberName,double accountBalance,double maxwithLimt, String memberNID) {
		super(memberName, accountBalance, 0);
		this.maxWithLimit=maxWithLimit;
	}
	private  double calculateInterest() {
		double aB= getAccountBalance();
		double iA=aB*interest;
		return iA;
	}
	public double getNetBalance() {
		double iA=calculateInterest();
		double aB=getAccountBalance();
		double tA=iA+aB;
		return tA;
	}
	@Override
	 public void withdraw(double withAmount) {
		 if(withAmount>maxWithLimit) {
			 super.withdraw(withAmount);
		 }
		 else
			 System.out.println("Your withdraw amount is bigger than maximum withdraw limit.");
	 }
	@Override
	 public void withdraw(double withAmount,String TransactionType) {
		 if(withAmount>maxWithLimit) {
			 super.withdraw(withAmount,TransactionType);
		 }
		 else
			 System.out.println("Your withdraw amount is bigger than maximum withdraw limit.");
	 }
	 public SavingsAccount(String memberName, String memberNID, double accountBalance, double minimumBalance,
			double interest, double maxWithLimit) {
		super(memberName,  accountBalance, minimumBalance);
		this.interest = interest;
		this.maxWithLimit = maxWithLimit;
	}
	public void setMaxWithLimit(double newMaxWithLimit) {
		 maxWithLimit=newMaxWithLimit;
	 }
	 public double getMaxWithLimit() {
		 return maxWithLimit;
	 }
	 @Override
	 public String toString() {
		 return String.format("%s\t%.2f", super.toString(),maxWithLimit);
	 }
}
