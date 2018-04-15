package com.chapter.one;

public class Franc extends Money {

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier){
        return  new Franc(multiplier*this.amount);
    }

}
