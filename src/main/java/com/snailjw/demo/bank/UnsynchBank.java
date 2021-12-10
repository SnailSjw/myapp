package com.snailjw.demo.bank;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行实体类
 *
 * @author : snail
 * @date : 2021-12-08 13:10
 **/
public class UnsynchBank {
    private final double[] accounts;

    private Lock bankLock = new ReentrantLock();
    public UnsynchBank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }
    public void transfer(int from,int to,double amount){
        bankLock.lock();
        try {
            if (accounts[from] < amount) {
                return;
            }
            System.out.print(Thread.currentThread());
            accounts[from] -=amount;
            System.out.printf(" %10.2f from %d to %d",amount,from,to);
            accounts[to] +=amount;
            System.out.printf(" Total Balance:%10.2f%n",getTotalBalance());
        }finally {
            bankLock.unlock();
        }
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double a : accounts){
            sum +=a;
        }
        return sum;
    }
    public int size(){
        return accounts.length;
    }

    public static void main(String[] args) {
        UnsynchBank unsynchBank = new UnsynchBank(4,1000);
        unsynchBank.transfer(1,2,300);
        System.out.println("bank.size() = " + unsynchBank.size());
    }
}
