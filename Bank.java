package Bank;

import java.util.ArrayList;

public class Bank {
    private double credit=0;
    public ArrayList<Account> accountList=null;
    private int id=0;

    public Bank() {
        this.id++;
    }
public void setBank () throws Exception{
        if (this.accountList==null) throw new Exception("No accounts");
    for (int i=0;i<accountList.size();i++){
        this.accountList.get(i).setIban(id + accountList.get(i).getIban());
        this.credit += accountList.get(i).getCredit();
    }
}
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getId() {
        return id;
    }


    public double getTotalCredit(){
        double sum=0;
        for (int i=0; i<this.accountList.size();i++)
        sum+=this.accountList.get(i).getCredit();
        return sum;
    }

    @Override
    public String toString() {
        String s="Bank "+ id +
                " { credit=" + credit +
                ", Accounts= "+accountList+'}';
        return s;
    }
}