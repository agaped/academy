package com.chapter.one;

public class Money {
    protected  int amount;

    public boolean equals(Object obj) {
        Money money=(Money) obj;
        return this.amount==money.amount && getClass().equals(money.getClass());
    }

}
