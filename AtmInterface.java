package atm;

import java.util.Scanner;

//Class to represent the user's bank account
class BankAccount {
 private double balance;

 // Constructor
 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 // Deposit method
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Successfully deposited: $" + amount);
     } else {
         System.out.println("Invalid deposit amount!");
     }
 }

 // Withdraw method
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Successfully withdrawn: $" + amount);
     } else if (amount > balance) {
         System.out.println("Insufficient balance!");
     } else {
         System.out.println("Invalid withdrawal amount!");
     }
 }

 // Check balance method
 public void checkBalance() {
     System.out.println("Current Balance: $" + balance);
 }
}

//Class to represent the ATM machine
class ATM {
 private BankAccount account;
 private Scanner scanner;

 // Constructor
 public ATM(BankAccount account) {
     this.account = account;
     this.scanner = new Scanner(System.in);
 }

 // Method to display the menu
 public void displayMenu() {
     System.out.println("\n===== ATM MENU =====");
     System.out.println("1. Check Balance");
     System.out.println("2. Deposit Money");
     System.out.println("3. Withdraw Money");
     System.out.println("4. Exit");
     System.out.print("Choose an option: ");
 }

 // Method to start ATM operations
 public void start() {
     int choice;
     do {
         displayMenu();
         while (!scanner.hasNextInt()) {
             System.out.println("Invalid input! Please enter a number.");
             scanner.next(); // Clear invalid input
         }
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 account.checkBalance();
                 break;
             case 2:
                 System.out.print("Enter amount to deposit: ");
                 double depositAmount = scanner.nextDouble();
                 account.deposit(depositAmount);
                 break;
             case 3:
                 System.out.print("Enter amount to withdraw: ");
                 double withdrawAmount = scanner.nextDouble();
                 account.withdraw(withdrawAmount);
                 break;
             case 4:
                 System.out.println("Thank you for using the ATM. Goodbye!");
                 break;
             default:
                 System.out.println("Invalid choice! Try again.");
         }
     } while (choice != 4);
 }
}

//Main class
public class AtmInterface {
 public static void main(String[] args) {
     // Create a bank account with initial balance
     BankAccount userAccount = new BankAccount(1000.0);

     // Create ATM object and start ATM interface
     ATM atm = new ATM(userAccount);
     atm.start();
 }
}
