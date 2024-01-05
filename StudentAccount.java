package BankingLibrary;

public class StudentAccount extends SavingsAccount{
	private String studentId;
	private String institutionName;
	
	public StudentAccount(String memberName, String memberNID,double accountBalance,  
			String studentId, String institutionName) {
		super(memberName, accountBalance, 20000, memberNID);
		this.studentId = studentId;
		this.institutionName = institutionName;
	}
	
}
