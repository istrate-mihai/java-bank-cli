import Classes.BankAccount;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String accountNumber;
        double amount;

        final int ACCOUNT_LIMIT    = 5;
        boolean isMenuOpened       = true;
        BankAccount chosenAccount  = null;

        Scanner scanner            = new Scanner(System.in);
        BankAccount[] bankAccounts = new BankAccount[ACCOUNT_LIMIT];

        String[] options           = {
            "Create account",
            "Deposit",
            "Withdraw",
            "Check balance",
            "Print transaction history",
            "Show total accounts",
        };

        while (isMenuOpened) {
            System.out.println("===== BANK MENU =====");
            System.out.println("Enter a number from the options below: ");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + "." + options[i]);
            }
            System.out.println("0. Exit");
            int option = scanner.nextInt();

            if (option == 0) {
                isMenuOpened = false;
                System.out.println("Goodbye!!!");
                continue;
            }

            if (option == 1) {
                System.out.println(BankAccount.getTotalAccounts());
                if (BankAccount.getTotalAccounts() == ACCOUNT_LIMIT) {
                    System.out.println("Maximum accounts reached: ");
                    continue;
                }
                System.out.println("Enter Account Number: ");
                scanner.nextLine();
                accountNumber = scanner.nextLine();

                System.out.println("Enter Account Owner: ");
                String accountOwner = scanner.nextLine();

                System.out.println("Enter Initial Account Deposit: ");
                amount = scanner.nextDouble();
                scanner.nextLine();

                int currentIndex           = BankAccount.getTotalAccounts();
                bankAccounts[currentIndex] = new BankAccount(accountNumber, accountOwner, amount);
                System.out.println("Account created successfully: ");
            }

            if (option == 2 || option == 3 || option == 4 || option == 5) {
                if (BankAccount.getTotalAccounts() == 0) {
                    System.out.println("No accounts created yet, please create an account");
                    continue;
                }
                System.out.println("Choose account, enter account number: ");
                scanner.nextLine();
                accountNumber = scanner.nextLine();

                int totalAccounts = BankAccount.getTotalAccounts();
                for (int i = 0; i < totalAccounts; i++) {
                    if (accountNumber.equals(bankAccounts[i].getAccountNumber())) {
                        chosenAccount = bankAccounts[i];
                    }
                }

                if (chosenAccount == null) {
                    System.out.println("Account not found: ");
                    continue;
                }
            }

            if (option == 2) {
                System.out.println("Enter amount to deposit: ");
                amount = scanner.nextDouble();
                chosenAccount.deposit(amount);
            }

            if (option == 3) {
                System.out.println("Enter amount to withdraw: ");
                amount = scanner.nextDouble();
                chosenAccount.withdraw(amount);
            }

            if (option == 4) {
                System.out.println("Account balance: " + chosenAccount.getBalance());
            }

            if (option == 5) {
                System.out.println("Transaction history: ");
                chosenAccount.printHistory();
            }

            if (option == 6) {
                System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
                int totalAccounts = BankAccount.getTotalAccounts();
                for (int i = 0; i < totalAccounts; i++) {
                    System.out.println(bankAccounts[i]);
                }
            }

            if (
                option != 1 &&
                option != 2 &&
                option != 3 &&
                option != 4 &&
                option != 5 &&
                option != 6
            ) {
                System.out.println("Invalid Option");
            }

            chosenAccount = null;
        }
    }
}
