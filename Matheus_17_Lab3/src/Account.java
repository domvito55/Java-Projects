/*
Student ID: 301236904
Name: Matheus Teixeira
Assignment: 3
*/
abstract class Account extends Consumer {
    //fields
    protected int accountNum;

    //Constructor
    Account(String id, String name, int accountNum){
        super(id, name);
        this.accountNum = accountNum;
    }

    //Setters
    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }
    //Getters
    public int getAccountNum() {
        return accountNum;
    }

    //methods
    abstract void withdraw(double amount);
    abstract void deposit(double amount);

    @Override
    public String toString(){
        return super.toString() + " - accountNum: " + accountNum;
    }
}
