import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {


    public double balance;

    public final Lock lock = new ReentrantLock();

    public BankAccount(double balance){
        this.balance = balance;
    }



    public boolean withdrawAmount(double withdrawlAmt)  {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw");
        try {
            if (lock.tryLock(4000, TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() +" proceeding to withdraw " + withdrawlAmt);
                    if (this.balance >= withdrawlAmt) {
                        Thread.sleep(3000);
                        this.balance -= withdrawlAmt;
                        return true;
                    } else {
                        System.out.println(Thread.currentThread().getName() +" cannot be withdraw amount "+ withdrawlAmt +" because of insufficient balance");
                    }
                } catch(InterruptedException e){
                    System.out.println(Thread.currentThread().getName() +" processing got interrupted while withdrawing amount.");
                    e.printStackTrace();
                } finally{
                    lock.unlock();
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " could not acquire lock. Please try again later!!");
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName() + " checked current Account Balance as: " + this.balance);
        }
        return false;
    }

    public void viewBalance(){
        System.out.println("Current Account Balance: " + this.balance);
    }
}
