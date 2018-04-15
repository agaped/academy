package com.chapter.one;

public class Dollar extends Money{

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int multiplier){
        return  Money.dollar(multiplier*this.amount);
    }

}
