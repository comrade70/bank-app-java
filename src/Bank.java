/*
 COURSE:         OBJECT ORIENTED DESIGN AND PROGRAMMING
 COURSE CODE:    CPE 310
 NAME:           OGUNRONBI JOSEPH ADEMOLA
 MATRIC:         FTP/CPE/22/0054727
 ASSIGNMENT/TEST
 */

import java.util.ArrayList;
import java.util.Scanner;

class Account {
private int accountNumber;
private String name;
private double balance;
private String type;
private static int lastAccountNumber = 0;
private String bvn;

public Account(String name, double balance, String type) {
    this.accountNumber = ++lastAccountNumber;
    this.name = name;
    this.balance = balance;
    this.type = type;
}

public int getAccountNumber() {
    return accountNumber;
}

public String getName() {
    return name;
}

public double getBalance() {
    return balance;
}

public String getType() {
    return type;
}

public void deposit(double amount) {
    balance += amount;
    System.out.println("$" + amount + " deposited successfully.");
}

public void withdraw(double amount) {
    if (balance >= amount) {
        balance -= amount;
        System.out.println("$" + amount + " withdrawn successfully.");
    } else {
        System.out.println("Insufficient balance!");
    }
}

public void transfer(Account receiver, double amount) {
    if (balance >= amount) {
        balance -= amount;
        receiver.deposit(amount);
        System.out.println("$" + amount + " transferred successfully.");
    } else {
        System.out.println("Insufficient balance!");
    }
}

public void displayBalance() {
    System.out.println("Balance: $" + balance);
}

public void displayStatement() {
    System.out.println("Account Number : #" + accountNumber);
    System.out.println("Account Holder : " + name);
    System.out.println("Account Balance : $" + balance);
}

public static int getLastAccountNumber() {
    return lastAccountNumber;
}

public void createBVN(ArrayList<Account> accounts, String bankName) {
    this.bvn = bankName + "-" + String.format("%06d", accountNumber);
    System.out.println("BVN number generated : " + bvn);
}

public String getBVN() {
    return bvn;
}


}

class User {
private String name;
private String password;
public User(String name, String password) {
    this.name = name;
    this.password =password;
}
public String getName() {
    return name;
}

public String getPassword() {
    return password;
}

}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();

        boolean quit = false;
        Account account = null; // declare and initialize to null
        while (!quit) {
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the initial deposit: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter account type (Savings or Current): ");
                    String type = scanner.nextLine();

                    account = new Account(name, balance, type); // initialize here
                    account.createBVN(accounts, "MyBank");

                    accounts.add(account);
                    System.out.println("Account created successfully.");
                    break;
                case 2:
                    if (account == null) { // check if account is initialized
                        System.out.println("Please create an account first.");
                        break;
                    }
                    // rest of the code
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid Option. Try Again.");
                    break;
            }
        }
        scanner.close();
    }
}

