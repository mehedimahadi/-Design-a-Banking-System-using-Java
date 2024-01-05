package BankingLibrary;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BankApp {
	public static void main(String[] args) {
		Bank acc = new Bank("UAP Bank");
		int option1, option2, option3;
		while(true) {
			String user=JOptionPane.showInputDialog("Enter '1' If you are an Employee\nEnter '2' If you are an Account Holder.\nEnter '0' to Exit.\nEnter Your Choice: ");
			option1 = Integer.parseInt(user);
			if(option1==0) break;
			else if(option1==1) {
				while(true) {
					user=JOptionPane.showInputDialog("Input '1' to add new Account.\nInput '2' to deposit to an existing Account.\nInput '3' to withdraw from an Account.\nInput '4' to transfer money from one account to another account.\nInput '5' to display the summary of a specific account.\nInput '6' to display the transactions of a specific account.\nInput '7' to display the list of account of specific type.\nInput ‘8’ to display the list of all accounts.\nInput '0' to exit the System.\nEnter Your Choice: ");
					option2 = Integer.parseInt(user);
					if(option2==0) {
						JOptionPane.showMessageDialog(null,"Thank You For Banking With Us!");
						break;
					}
					else if(option2==1) {
						user=JOptionPane.showInputDialog("Enter '1' to Create Savings Account.\nEnter '2' to Create Current Account.\nInput '3' to Create Student Account.\nEnter Your Choice: ");
						option3 = Integer.parseInt(user);
						if(option3==1) {
							String name=JOptionPane.showInputDialog("Enter Your Name: ");
							String nid=JOptionPane.showInputDialog("Enter Your NID Number: ");
							String balance=JOptionPane.showInputDialog("Enter Your Initial Balance: ");
							double initialBalance=Integer.parseInt(balance);
							String maxLim =JOptionPane.showInputDialog("Enter Your Max Withdraw Limit: ");
							double maxLimit=Integer.parseInt(maxLim);
							acc.addAccount(name, initialBalance, maxLimit, nid);
							JOptionPane.showMessageDialog(null, "Your Savings Account Created Successfully!");
						}
						else if(option3==2) {
							String name=JOptionPane.showInputDialog("Enter Your Name: ");
							String nid=JOptionPane.showInputDialog("Enter Your NID Number: ");
							String balance=JOptionPane.showInputDialog("Enter Your Initial Balance: ");
							double initialBalance=Integer.parseInt(balance);
							String license=JOptionPane.showInputDialog("Enter Your Trade License Number: ");
							acc.addAccount(name, initialBalance, nid, license);
							JOptionPane.showMessageDialog(null,"Your Current Account Created Successfully!");
						}
						else if(option3==3) {
							String name=JOptionPane.showInputDialog("Enter Your Name: ");
							String nid=JOptionPane.showInputDialog("Enter Your NID Number: ");
							String id=JOptionPane.showInputDialog("Enter Your ID Number: ");
							String insName=JOptionPane.showInputDialog("Enter Your Institution Name: ");
							String balance=JOptionPane.showInputDialog("Enter Your Initial Balance: ");
							double initialBalance=Integer.parseInt(balance);
							acc.addAccount(name, initialBalance, nid, id, insName);
						}
						else System.out.println("Invaild Input!");
					}
					else if(option2==2) {
						String accNum=JOptionPane.showInputDialog("Enter Your Account Number: ");
						String amt=JOptionPane.showInputDialog("Enter Your Deposit Amount: ");
						double deptAmt=Integer.parseInt(amt);
						acc.deposit(accNum, deptAmt);
					}
					else if(option2==3) {
						String accNum=JOptionPane.showInputDialog("Enter Your Account Number: ");
						String amt=JOptionPane.showInputDialog("Enter Your Withdraw Amount: ");
						double withAmt=Integer.parseInt(amt);
						acc.withdraw(accNum, withAmt);
					}	
					else if(option2==4) {
						String accNum1=JOptionPane.showInputDialog("Enter Sender Account Number: ");
						String accNum2=JOptionPane.showInputDialog("Enter Receiver Account Number: ");
						String amt=JOptionPane.showInputDialog("Enter Your Withdraw Amount: ");
						double withAmt=Integer.parseInt(amt);
						acc.transfer(accNum1, accNum2, withAmt);
					}
					else if(option2==5) {
						String accNum=JOptionPane.showInputDialog("Enter Your Account Number: ");
						System.out.println("Account Details: "+acc.getAccountSummary(accNum));
					}
					else if(option2==6) {
						String accNum=JOptionPane.showInputDialog("Enter Your Account Number: ");
						ArrayList<Transaction> trans=acc.getAccTransactions(accNum);
						for(Transaction tran : trans) {
							System.out.println(tran.toString());
						}
					}
					else if(option2==7) {
						String type=JOptionPane.showInputDialog("Enter The Type of Account You Want to See: ");
						ArrayList<BankAccount> SAcc  =acc.getAccounts(type);
						for(BankAccount accD : SAcc) {
							if(accD.getClass().getSimpleName().equalsIgnoreCase(type)) {
								System.out.println(accD.toString());
							}
						}
					}
					else  if(option2==8) {
					acc.getListOfAccounts();
					}
				}
			}
			else if(option1==2) {
				String nid=JOptionPane.showInputDialog("Enter Your NID Number: ");
				ArrayList<BankAccount> fAcc =acc.findAccounts(nid);
				
				user=JOptionPane.showInputDialog("Input ‘5’ to display the summary of one of Your account.\nInput ‘6’ to display the transactions of one of Your account.\nInput '8' to display All of Your AccountS.\nInput '0' to exit the System.\nEnter Your Choice: ");
				option2 = Integer.parseInt(user);
				while(true) {
					if(option2==0) {
						JOptionPane.showMessageDialog(null,"Thank You For Banking With Us!");
						break;
					}
					else if(option2==5) {
						boolean c = true;
						String accNum=JOptionPane.showInputDialog("Enter Your Account Number: ");
						ArrayList<BankAccount> Acc =acc.findAccounts(accNum);
						for(BankAccount allAcc: Acc) {
							if(allAcc.getAccountNumber().equals(accNum)) {
								System.out.println(allAcc.toString());
								c=false;
								break;
							}
						}
						if(c) System.out.println("Account Details Does not Matched with NID Details!");
					}
					else if(option2==6) {
						boolean c = true;
						String accNum=JOptionPane.showInputDialog("Enter Your Account Number: ");
						ArrayList<BankAccount> Acc =acc.findAccounts(accNum);
						for(BankAccount allAcc: Acc) {
							if(allAcc.getAccountNumber().equals(accNum)) {
								ArrayList<Transaction> dTran=allAcc.getTransactions();
								c=false;
								for(Transaction Tacc : dTran) {
									System.out.println(Tacc.toString());
								}
								break;
							}
						}
						if(c) System.out.println("Account Details Does not Matched with NID Details!");
					}
					else if(option2==8) {
						for(int i=0; i<fAcc.size(); i++) {
							System.out.println(fAcc.get(i));
						}
					}
				}
			}
		}
	}
}
