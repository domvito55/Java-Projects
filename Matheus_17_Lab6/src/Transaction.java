/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: Lab 6
*/
public class Transaction implements Runnable{
    //properties
    private Account sharedAccount;
    private TransactionType type;
    private double amount;

    //Constructor
    Transaction(Account sharedAccount, TransactionType type, double amount){
        this.sharedAccount = sharedAccount;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public void run() {
        synchronized (sharedAccount){
            sharedAccount.performTransaction(type, amount);
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println(sharedAccount);
        }
    }

}
