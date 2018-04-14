package com.chapter.one;

public class Dollar {

     private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier){
        return  new Dollar(multiplier*this.amount);
    }

    @Override
    public boolean equals(Object obj) {
        Dollar dollar=(Dollar) obj;
        return this.amount==dollar.amount;
    }
}
