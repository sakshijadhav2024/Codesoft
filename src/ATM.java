import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void checkBalance() {
        double balance = account.getBalance();
        System.out.println("Your account balance: $" + balance);
    }

    private void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    private void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Current balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.0); // Initial balance set to 1000.0
        ATM atm = new ATM(bankAccount);
        atm.start();
    }
}
