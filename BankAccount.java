import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.List;

public class BankAccount implements Comparable<BankAccount>, Measurable{
     public float balance;
     public float rate;
     public int numberOfYear;
     public BankAccount(float b, float r, int n){
        this.balance = b;
        this.rate = r;
        this.numberOfYear = n;
    }
    /* overload constructor for initial balance to 0 when client create a object
    public BankAccount(float r){

    this.rate = r;

    }*/
    float processYear(){
        balance = balance + balance * rate;
        return balance;
    }
    float processNYears(int n) {
        for (int i = 0; i < n; i++) {
            balance = processYear();
        }
        return balance;
    }
    @Override
    public int compareTo(BankAccount bankAccount) {
        if(this.balance > bankAccount.balance){
            return 1;
        }
        else if(this.balance == bankAccount.balance){
            return 0;
        }
        else{
            return -1;
        }
    }
    public List<BankAccount> sort(BankAccount a, BankAccount b, BankAccount c){
        List<BankAccount> list = new ArrayList<>(); {
            if(a.compareTo(b) > 0 && a.compareTo(c) > 0){
                list.add(a);
                if(b.compareTo(c) > 0){
                    list.add(b);
                    list.add(c);
                }
                else{
                    list.add(c);
                    list.add(b);
                }
            }
            else if(b.compareTo(a) > 0 && b.compareTo(c) > 0){
                list.add(b);
                if(a.compareTo(c) > 0){
                    list.add(a);
                    list.add(c);
                }
                else{
                    list.add(c);
                    list.add(a);
                }
            }
            else if(c.compareTo(a)> 0 && c.compareTo(b)> 0){
                list.add(c);
                if(b.compareTo(a) > 0){
                    list.add(b);
                    list.add(a);
                }
                else{
                    list.add(a);
                    list.add(b);
                }
            }
        }
        return list;
    }

    @Override
    public float getMeasure() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }

    public static void main(String [] args) {
        /**\
         * Part 1
         */

        float balance = 1000;
        float rate = .1f;
        int n = 5;
        BankAccount account = new BankAccount(balance, rate, n);
        BankAccount a = new BankAccount(1000, rate, n);
        BankAccount b = new BankAccount(2000, rate, n);
        BankAccount c = new BankAccount(3000, rate, n);


        List<BankAccount> list =account.sort( a,  b,  c);
        System.out.println("Print list in order: ");
        System.out.println(list.toString());


        System.out.println("Average of all account:  ");
        System.out.println(Measurable.average(list));

        //System.out.println("balance after one years is: " + account.processYear());
        //System.out.println("balance after " + n +" years is: " + account.processNYears(n));
        /**
         * part2
         */


    }


}