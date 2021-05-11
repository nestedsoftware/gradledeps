package com.simplelibclient.hierarchy;

public class Country {
    private State _state;

    public Country(State state) {
        _state = state;
    }

    public void doStuff() {
        _state.doStuff();
    }
}
