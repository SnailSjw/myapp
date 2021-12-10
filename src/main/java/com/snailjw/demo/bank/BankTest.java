package com.snailjw.demo.bank;

/**
 * 多线程测试
 *  示例：模拟同一家银行的不同账户之间相互转账
 * @author : snail
 * @date : 2021-12-08 13:08
 **/
public class BankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMONT = 1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
//        UnsynchBank bank = new UnsynchBank(NACCOUNTS,INITIAL_BALANCE);
        SynchBank bank = new SynchBank(NACCOUNTS,INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = ()->{
                while (true){
                    try {
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMONT * Math.random();
                        bank.transfer(fromAccount,toAccount,amount);
                        Thread.sleep((long) (DELAY * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
