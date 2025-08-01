public class Person implements Runnable{

    private BankAccount jointBankAccount;
    private double withdrawlAmt;

    Person(BankAccount bankAccount){
        this.jointBankAccount = bankAccount;
    }

    public void setWithdrawlAmt(double withdrawlAmt){
        this.withdrawlAmt = withdrawlAmt;
    }

    @Override
    public void run() {
        jointBankAccount.withdrawAmount(this.withdrawlAmt);
        jointBankAccount.viewBalance();
    }
}
