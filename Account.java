package Bank;

public class Account {
    private double credit;
    private String iban;
    private User user;

    public Account(double credit, User user) {
        this.credit = credit;
        this.iban = user.getCf();
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "credit=" + credit +
                ", iban='" + iban + '\'' +
                ", user=" + user +
                '}';
    }
}
