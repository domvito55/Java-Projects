/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: 3
*/
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount extends Account {
    //fields
    private double balance;

    //constructors
    public SavingsAccount(String id, String name, int accountNum) {
        super(id, name, accountNum);
        this.balance = 0.0;
    }
    public SavingsAccount(String id, String name, int accountNum, double balance) {
        super(id, name, accountNum);
        this.balance = balance;
    }

    //Setters
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Getters
    public double getBalance() {
        return balance;
    }

    //methods
    public void withdraw(double amount){
        BigDecimal formattedBalance = BigDecimal.valueOf(this.balance).setScale(2, RoundingMode.HALF_UP);
        if(this.balance < amount){
            throw new IllegalArgumentException("\n_______An exception has occurred_______\n" +
                    " You don't have enough money to complete this transaction.\n " +
                    "You tried to withdraw $" + amount + ", but your current balance is $" +
                    formattedBalance + ".\n Try again with a valid value. It must be less then or " +
                    "equal to: " + formattedBalance + "\n_______________________________________\n");
        }
        if(this.balance - amount < 3000){
            BigDecimal allowed = BigDecimal.valueOf(this.balance-3000).setScale(2, RoundingMode.FLOOR);
            throw new IllegalArgumentException("\n_______An exception has occurred_______\n" +
                    "This operation cannot be completed\n" +
                    "You must keep, at least, $3000.00 in your Savings Account.\n" +
                    "You tried to withdraw $" + amount + ", but your current balance is $" + formattedBalance +
                    ";\ntherefore the maximum withdraw value allowed is $" +
                    allowed + "." + "\n_______________________________________\n");
        }
        this.balance -= amount;
        formattedBalance = BigDecimal.valueOf(this.balance).setScale(2, RoundingMode.HALF_UP);
        System.out.println("You have just withdrawn $" + amount +
                "\nYour new balance is: $" + formattedBalance);
    }

    public void deposit(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("\n_______An exception has occurred_______\n" +
                    " This operation cannot be completed.\n" +
                    " You cannot deposit negative values.\n" +
                    " You tried to deposit: " + amount + " dollars.\n" +
                    " You must either deposit a " +
                    "positive value or try a withdraw operation." +
                    "\n_______________________________________\n");
        }
        this.balance += amount;
        BigDecimal formattedBalance = BigDecimal.valueOf(this.balance).setScale(2, RoundingMode.HALF_UP);
        System.out.println("You have just deposited $" + amount +
                "\nYour new balance is: $" + formattedBalance);
    }

    @Override
    public String toString(){
        BigDecimal formattedBalance = BigDecimal.valueOf(this.balance).setScale(2, RoundingMode.HALF_UP);
        return super.toString() + " - balance: " + formattedBalance;
    }
}