public class Account {

    double balance = 0.0;

    public void deposit(double amt){ }

    public void withdraw(double amt){ }

    public double getBalance(){
        return balance;
    }

}

class AccountHolder {
    int id;
    String address;
    Account accounts[];

    public int nextId() { return id; } //The question seems to need a return of int so the body is a placeholder
}

class IndividualHolder extends AccountHolder {

    String name;
    String ssn;
}

class CoporateHolder extends AccountHolder {
    String contact;
}
