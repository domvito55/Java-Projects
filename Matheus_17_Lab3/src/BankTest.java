/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: 3
*/
public class BankTest {
    public static void main(String[] args) {
        Bank branch1 = new Bank();
        Bank branch2 = new Bank();

        //branch1 test
        System.out.println("\nBranch 1 test");
        System.out.println(branch1);

        //Test 1 - Savings Account withdraw
        System.out.println("\n####### Test 1 - Savings withdraw - Account to be tested:");
        System.out.println(branch1.accountList.get(0));
        //Allowed transaction
        System.out.println("\nValid transaction test: ");
        branch1.accountList.get(0).withdraw(200);
        //Trying to withdraw an amount greater than the balance
        try{
            branch1.accountList.get(0).withdraw(4000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Trying to withdraw an amount that will let less than $3000 as balance
        try{
            branch1.accountList.get(0).withdraw(500);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Test 2 - Savings Account deposit
        System.out.println("\n####### Test 2 - Savings deposit - Account to be tested:");
        System.out.println(branch1.accountList.get(0));
        //Allowed transaction
        System.out.println("\nValid transaction test: ");
        branch1.accountList.get(0).deposit(200);
        //Trying to deposit negative values.
        try{
            branch1.accountList.get(0).deposit(-500);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Test 3 - Chequing Account withdraw
        System.out.println("\n####### Test 3 - Chequing withdraw - Account to be tested:");
        System.out.println(branch1.accountList.get(3));
        //Allowed transaction
        System.out.println("\nValid transaction test: ");
        branch1.accountList.get(3).withdraw(92000);
        //Trying to withdraw an amount greater than the balance + 2000
        try{
            branch1.accountList.get(3).withdraw(2000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Test 4 - Chequing Account deposit
        System.out.println("\n####### Test 4 - Chequing deposit - Account to be tested:");
        System.out.println(branch1.accountList.get(3));
        //Allowed transaction
        System.out.println("\nValid transaction test: ");
        branch1.accountList.get(3).deposit(92000);
        //Trying to deposit negative values.
        try{
            branch1.accountList.get(0).deposit(-500);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        /*************************************************************************************/
        System.out.println("*****************************************************************");
        //branch2 test
        System.out.println("\nBranch 2 test");
        System.out.println(branch2);

        //Test 5 - Savings Account withdraw
        System.out.println("\n####### Test 5 - Savings withdraw - Account to be tested:");
        System.out.println(branch2.accountList.get(1));
        //Allowed transaction
        System.out.println("\nValid transaction test: ");
        branch2.accountList.get(1).withdraw(35000);
        //Trying to withdraw an amount greater than the balance
        try{
            branch2.accountList.get(1).withdraw(8000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Trying to withdraw an amount that will let less than $3000 as balance
        try{
            branch2.accountList.get(1).withdraw(5000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Test 6 - Savings Account deposit
        System.out.println("\n####### Test 6 - Savings deposit - Account to be tested:");
        System.out.println(branch2.accountList.get(1));
        //Allowed transaction
        System.out.println("\nValid transaction test: ");
        branch2.accountList.get(1).deposit(35000);
        //Trying to deposit negative values.
        try{
            branch2.accountList.get(1).deposit(-500);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Test 7 - Chequing Account withdraw
        System.out.println("\n####### Test 7 - Chequing withdraw - Account to be tested:");
        System.out.println(branch2.accountList.get(4));
        //Allowed transaction
        System.out.println("\nValid transaction test: ");
        branch2.accountList.get(4).withdraw(43000);
        //Trying to withdraw an amount greater than the balance + 2000
        try{
            branch2.accountList.get(4).withdraw(4000);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        //Test 8 - Chequing Account deposit
        System.out.println("\n####### Test 8 - Chequing deposit - Account to be tested:");
        System.out.println(branch2.accountList.get(4));
        //Allowed transaction
        System.out.println("\nValid transaction test: ");
        branch2.accountList.get(4).deposit(43000);
        //Trying to deposit negative values.
        try{
            branch2.accountList.get(1).deposit(-500);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}