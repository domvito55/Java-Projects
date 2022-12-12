/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: Lab 6
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransactionTest {
    public static void main(String args[]) {
        Account sharedAccount = new Account("John");
        Transaction t1 = new Transaction(sharedAccount, TransactionType.WITHDRAW, 200);
        Transaction t2 = new Transaction(sharedAccount, TransactionType.DEPOSIT, 1000);
        Transaction t3 = new Transaction(sharedAccount, TransactionType.DEPOSIT, 500);
        Transaction t4 = new Transaction(sharedAccount, TransactionType.WITHDRAW, 100);

        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("Performing transactions");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println(sharedAccount);
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.shutdown();

        try{
            //wait 1 minute for the threads to complete execution
            boolean taskEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);
            if (taskEnded){
                System.out.println("SharedAccount: " + sharedAccount);
            }else{
                System.out.println("Timed out while waiting for task completion...no array to display");
            }
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
}