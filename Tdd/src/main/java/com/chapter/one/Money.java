package com.chapter.one;

public class Money implements Expression{
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

    public Expression plus(Money addend) {
        return new Sum(this,addend);
    }

    public Money reduce(Bank bank, String to){
        int rate=bank.rate(currency, to);
        return new Money(amount/rate, to);
    }
}
