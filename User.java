package Bank;

import java.util.ArrayList;

public class User {
    private String cf;
    private ArrayList<Account> myAccounts;

    public User(String cf) {
        this.cf = cf;
    }

    public ArrayList<Account> getMyAccounts() {
        return myAccounts;
    }

    public void setMyAccounts(ArrayList<Account> myAccounts) {
        this.myAccounts = myAccounts;
    }

    public String getCf() {
        return cf;
    }

    @Override
    public String toString() {
        int counter=0;
        String s = "{" +
                "CF='" + cf + '\'' +
                ", Accounts owned=";
        for (int i=0;i< myAccounts.size();i++)
            counter++;
        s+= counter +" }";
        return s;
    }
}