public class MainDriver {

    public static void main(String[] args) {
        BankAccount jointBankAccount = new BankAccount(1000.0); // common shared resource
//        Runnable raunakRunnable = new Runnable() {
//            @Override
//            public void run() {
//                jointBankAccount.withdrawAmount(500);
//            }
//        };
//
//        Runnable sayanRunnable = new Runnable() {
//            @Override
//            public void run() {
//                jointBankAccount.withdrawAmount(500);
//            }
//        };
//
//        Thread raunak = new Thread(raunakRunnable, "Raunak Chhajer");
//        Thread sayan = new Thread(sayanRunnable, "Sayantan Pal");

        Person raunakRunnable = new Person(jointBankAccount);
        Person sayanRunnable = new Person(jointBankAccount);

        raunakRunnable.setWithdrawlAmt(500.0);
        sayanRunnable.setWithdrawlAmt(500.0);

        Thread raunak = new Thread(raunakRunnable, "Raunak Chhajer");
        Thread sayan = new Thread(sayanRunnable, "Sayantan Pal");

        raunak.start(); // -->run() --> withdraw amount ()
        sayan.start();  // -->run() --> withdraw amount ()

    }

}
