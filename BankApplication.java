import java.util.Scanner;



class BankAccount {
	private int accountNumber;
	private double balance;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void withdraw(double amount) throws InsufficientFundException {
		if(amount > balance) {
			throw new InsufficientFundException("Insuffiecient Fund..");
		}
		balance = balance - amount;
		System.out.println("Current available balance is "+balance);
	}
}


class InsufficientFundException extends Exception {
	public InsufficientFundException(String msg) {
		super(msg);
	}
}


public class BankApplication {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		account.setAccountNumber(101);
		account.setBalance(5000);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter amount to be withdraw");
		double amount = scanner.nextDouble();
		
		try {
			account.withdraw(amount);
		} catch (InsufficientFundException e) {
			System.out.println("Exception:: "+e.getMessage());
		}
	}

}
