/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: 3
*/
import java.util.ArrayList;

public class Bank {
    //member
    static ArrayList<Account> accountList;

    //static block
    static
    {
        accountList = new ArrayList<Account>();
        accountList.add(new SavingsAccount("S101", "James Finch", 222210212, 3400.90));
        accountList.add(new SavingsAccount("S102", "Kell Forest", 222214500, 42520.32));
        accountList.add(new SavingsAccount("S103", "Amy Stone", 222212000, 8273.45));
        accountList.add(new ChequingAccount("C104", "Kaitlin Ross", 333315002, 91230.45));
        accountList.add(new ChequingAccount("C105", "Adem First", 333303019, 43987.67));
        accountList.add(new ChequingAccount("C106", "John Doe", 333358927, 34829.76));
    }

    @Override
    public String toString(){
        String result = "----------------------------\n";
        int counter = 1;

        for (Account account : accountList) {
            result = result + "#" + counter + " " + account.toString() + "\n";
            counter += 1;
        }

        result += "----------------------------";

        return result;
    }
}
