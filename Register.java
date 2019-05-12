package Bank;

import java.util.ArrayList;

public class Register {
	public ArrayList<Bank> bankList;

	public void setUserAccounts() throws Exception {
        if (this.bankList==null) throw new Exception("No banks");
        for (int i=0; i<this.bankList.size();i++)
            for (int j=0;j<this.bankList.size();j++)
	    this.bankList.get(i).accountList.get(j).getUser().setMyAccounts(getUserAccountsByIban(this.bankList.get(i).accountList.get(j).getIban()));

	}
	public Bank getBankById(int id){
		for (int i=0; i<this.bankList.size();i++){
			if(id==this.bankList.get(i).getId())
				return this.bankList.get(i);
		}return null;
	}
	public String printAllBanks() throws Exception {
        if (this.bankList==null) throw new Exception("No banks");
	    String s="";
        for (int i=0; i<this.bankList.size();i++)
            s+=" "+ this.bankList.get(i).getId()+ " - ";
	    return s;
    }
	public Account getAccountByIban(String iban) throws Exception {
        if (this.bankList==null) throw new Exception("No banks");
		for (int i=0; i<this.bankList.get(i).accountList.size();i++)
			for (int j=0; j<this.bankList.get(i).accountList.size();j++){
			if(iban.equals(this.bankList.get(i).accountList.get(j).getIban()))
				return this.bankList.get(i).accountList.get(j);
		}return null;
	}

    public ArrayList<Account> getUserAccountsByIban(String iban) throws Exception {
	    ArrayList<Account> list=null;
	    if (this.bankList==null) throw new Exception("No banks");
        for (int i=0; i<this.bankList.size();i++)
            for (int j=0; j<this.bankList.get(i).accountList.size();j++)
                if (iban.substring(2)==this.bankList.get(i).accountList.get(j).getIban().substring(2))
                    list.add(this.bankList.get(i).accountList.get(j));
                return list;

    }

    public String transfer(String one, String two, int money)throws Exception {
        //se il trasferimento di soldi va ad un account che è collegato ad una banca diversa si somma una commissione d un
        // euro, che verrà aggiunto al credito della banca dell'utente trasferente e non trasferito
        Account paying = this.getAccountByIban(one);
        Account receiving = this.getAccountByIban(two);
        int bank;
        double credit;
        if (paying.getCredit() < 0) throw new Exception("Insufficient fonds");
        if (!one.substring(0, 1).equals(two.substring(0, 1))) {
            bank = Integer.parseInt(one.substring(0, 1));
            credit = this.bankList.get(bank).getCredit();
            this.bankList.get(bank).setCredit(credit + 1);
            paying.setCredit(paying.getCredit() - (money + 1));
            receiving.setCredit(receiving.getCredit() + money);
            return "Payment with taxes completed";
        } else {
            paying.setCredit(paying.getCredit() - (money));
            receiving.setCredit(receiving.getCredit() + money);
            return "Payment completed";
        }
    }

    @Override
    public String toString() {
	    String s="Register{"+ bankList+'}';
	    return s;
    }
}