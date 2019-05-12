package Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank;
        Account account;
        User user;
        double credit;
        String cf;
        Register register= new Register();
        int choice, choice2, mainChoice, accountChoice, id;
        do {
            System.out.println("\tRegister Database\n1. New Bank and Accounts\n2. New Account\n3. Transfer money\n4. Print Register\n0. Exit");
            mainChoice = input.nextInt();
            switch (mainChoice) {
                case 0:
                    System.out.println("Goodbye");
                    break;
                case 1:
                    try{
                        do {
                            bank = new Bank();
                            do {
                                System.out.println("Bank #" + bank.getId());
                                System.out.println("Insert new Account Credit: ");
                                credit = input.nextDouble();
                                System.out.println("Account Owned by (cf):");
                                cf = input.next();
                                user = new User(cf);
                                account = new Account(credit, user);
                                bank.accountList.add(account);
                                System.out.println("Account #" + account.getIban() + " successfully created");
                                System.out.println("wanna add another account? 1-Yes 0-No");
                                choice = input.nextInt();
                            } while (choice!=0);
                            bank.setBank();
                            register.bankList.add(bank);
                            System.out.println("Bank #" + bank.getId()+ " successfully created");
                            register.setUserAccounts();
                            System.out.println("wanna add another bank? 1-Yes 0-No");
                            choice2 = input.nextInt();
                    } while (choice2 != 0);
                    user.setMyAccounts(register.getUserAccountsByIban(account.getIban()));
                    }catch (Exception e){
                    System.err.println(e);
                }
                    break;
                case 2:
                    try{
                        System.out.println("Insert new Account in which Bank? "+ register.printAllBanks());
                        bank= register.getBankById(input.nextInt());
                        if (bank==null) throw  new Exception("Bank not found");
                        do {
                            System.out.println("New Account: ");
                            System.out.println("Credit: ");
                            credit = input.nextDouble();
                            System.out.println("Owned by (cf):");
                            cf= input.next();
                            user = new User (cf);
                            account = new Account(credit, user);
                            bank.accountList.add(account);
                            System.out.println("wanna add another account? 1-Yes 0-No");
                            accountChoice = input.nextInt();
                        }while (accountChoice!=0);
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        System.out.println("insert who's sending money (IBAN)");
                        String iban = input.next();
                        System.out.println("insert who's receiving money (IBAN)");
                        String iban2 = input.next();
                        System.out.println("insert the amount of money (in Euros)");
                        int money = input.nextInt();
                        System.out.println(register.transfer(iban, iban2, money));
                    }catch (Exception e){
                        System.err.println(e);
                    }
                    break;
                case 4:
                    System.out.println(register);
                    break;
                case 5:
                    System.out.println("Which bank would you like to see the total credit of ? (insert ID)");
                    id=input.nextInt();
                    bank=register.getBankById(id);
                    System.out.println("Its current credit is:"+bank.getTotalCredit());
                default:
                    System.out.println("Errore, scelta non consentita");
                    break;
            }
        } while (mainChoice!=0);
    }
}
