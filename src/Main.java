import java.util.Scanner;
class UserAccount {
    private double balance;
    public UserAccount(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully Deposited.\nNew balance is: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter correct value.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.\nNew balance is: ₹" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds. Please try again.");
        }
    }
}
class ATM {
    private UserAccount userAccount;
    private Scanner scanner;
    public ATM(UserAccount userAccount) {
        this.userAccount = userAccount;
        this.scanner = new Scanner(System.in);
    }
    public void displayOptions() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Quit");
    }
    public void run() {
        while (true) {
            displayOptions();
            System.out.print("Select an option (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
    public void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Your account balance is: ₹" + balance);
    }
    public void deposit() {
        System.out.print("Enter the deposit amount: ₹");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
    }
    public void withdraw() {
        System.out.print("Enter the withdrawal amount: ₹");
        double amount = scanner.nextDouble();
        userAccount.withdraw(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        UserAccount userAccount = new UserAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}