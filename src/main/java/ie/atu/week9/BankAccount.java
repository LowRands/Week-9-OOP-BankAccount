package ie.atu.week9;

public class BankAccount {
    private String accNo;
    private String name;
    private double balance;

    public BankAccount(String accNo, String name, double balance)
    {
        if( balance <= 0)
        {
            throw new IllegalArgumentException("Balance must be greater than 0.");
        }
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
    public BankAccount(){

    }

    public String getACCNo() {
        return accNo;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
        System.out.println("Deposited " + balance + " to account " + accNo);
    }
    public void depositNegative(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        balance += amount;
    }

}
