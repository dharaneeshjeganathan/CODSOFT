package CodSoft;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }
}
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > 0) {
                    if (bankAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: $" + bankAccount.getBalance());
                    }
                } else {
                    System.out.println("Invalid amount for withdrawal");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    bankAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: $" + bankAccount.getBalance());
                } else {
                    System.out.println("Invalid amount for deposit");
                }
                break;
            case 3:
                System.out.println("Current balance: $" + bankAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
package CodSoft;
import java.util.Scanner;

public class BankAccMain {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter initial balance: $");
	        double initialBalance = scanner.nextDouble();
	        BankAccount userAccount = new BankAccount(initialBalance);
	        ATM atm = new ATM(userAccount);
	        while (true) {
	            atm.displayMenu();
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            atm.performTransaction(choice, scanner);
	        }
	    }
	}
