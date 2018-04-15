package com.chapter.one;

public class Money {
    protected  int amount;
    protected  String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency=currency;
    }

    public boolean equals(Object obj) {
        Money money=(Money) obj;
        return this.amount==money.amount && currency().equals(money.currency);
    }
    static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    static Money franc(int amount){
        return new Money(amount, "CHF");
    }

     Money times(int multiplier){
        return  new Money(multiplier*amount, currency);
    }

    String currency(){
        return this.currency;
    }

    public String toString(){
        return amount+" "+currency;
    }
}
