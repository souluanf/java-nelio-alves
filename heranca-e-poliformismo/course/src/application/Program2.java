package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program2 {
    public static void main(String[] args) {
        Account account1 = new Account(1001,"Alex",1000.0);
        account1.withDraw(200.0);
        System.out.println(account1.getBalance());

        Account account2 = new SavingsAccount(1002,"Maria",1000.0,0.01);
        account2.withDraw(200.0);
        System.out.println(account2.getBalance());

        Account account3 = new BusinessAccount(1003,"Bob",1000.0,500.0);
        account3.withDraw(200.0);
        System.out.println(account3.getBalance());
    }
}
