package com.simplelibclient.hierarchy;

import java.math.BigDecimal;

public class Country {
    private State _state;

    public Country(State state) {
        _state = state;
    }

    public void doStuff() {
        _state.doStuff();
    }

    public void transferTo(BigDecimal money) {
        System.out.println("added " + money);
    }
}
