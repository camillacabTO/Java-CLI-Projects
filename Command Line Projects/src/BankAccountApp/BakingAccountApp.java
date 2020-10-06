package BankAccountApp;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BakingAccountApp {

    public static void main(String[] args) {

        String fileName = "/Users/camilabarros/Downloads/original.csv";

        List<String[]> clientsData = CSV.read(fileName);
        ArrayList<Account> accounts = new ArrayList<>();

        for(String[] accountHolder : clientsData) {
            if(accountHolder[2].equals("Checking")) {
               accounts.add(new Checking(accountHolder[0],accountHolder[1],Double.parseDouble(accountHolder[3])));
            } else if(accountHolder[2].equals("Savings")) {
                accounts.add(new Savings(accountHolder[0],accountHolder[1],Double.parseDouble(accountHolder[3])));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }

        for (Account account : accounts) {
            account.showInfo();
            System.out.println("******************");
        }

    }
}
