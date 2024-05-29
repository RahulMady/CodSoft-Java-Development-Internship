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
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful.");
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                if (account.withdraw(withdrawalAmount)) {
                    System.out.println("Withdrawal successful.");
                }
                break;
            case 3:
                System.out.println("Current balance: $" + account.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM!");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();
            atm.processOption(choice);
        } while (choice != 4);
    }
}
