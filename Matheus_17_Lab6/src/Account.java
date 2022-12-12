/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: Lab 6
*/
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Account {
    //properties
    private String ownerName;
    private double balance = 1000.00;

    //Constructor
    Account(String ownerName){
        this.ownerName = ownerName;
    }

    //syncronized function
    public synchronized void performTransaction(TransactionType type, double amount){
//        System.out.println(this.toString());
        if(type == TransactionType.DEPOSIT){
            System.out.println("Trying to deposit $" + amount+  " to " + ownerName + "'s account");
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
            System.out.println("successfully deposited $" + amount +
                    " to " + ownerName + "'s account");
        }else{
            BigDecimal formattedBalance = BigDecimal.valueOf(this.balance).setScale(2, RoundingMode.HALF_UP);
//            System.out.println(this.toString());
            System.out.println("Trying to withdraw $" + amount+  " from " + ownerName + "'s account");
            if((this.balance) < amount){
                BigDecimal allowed = BigDecimal.valueOf(this.balance).setScale(2, RoundingMode.FLOOR);
                throw new IllegalArgumentException("\n_______An exception has occurred_______\n" +
                        " You don't have enough money to complete this transaction.\n" +
                        " You tried to withdraw $" + amount + ", but your current balance is: " +
                        formattedBalance + " dollars.\n" +
                        " Try again with a valid value. It must be less then or " +
                        "equal to: " + allowed + "." +
                        "\n_______________________________________\n");
            }
            this.balance -= amount;
            formattedBalance = BigDecimal.valueOf(this.balance).setScale(2, RoundingMode.HALF_UP);
            System.out.println("successfully withdrawn $" + amount +
                    " from " + ownerName + "'s account");
        }
    }


    @Override
    public String toString(){
        return "Account{ownerName='" + ownerName + "', balance=" + balance + "}";
    }

}
