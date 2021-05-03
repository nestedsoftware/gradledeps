package com.simplelibclient.hierarchy;

public class State {
    private City _city;

    public State(City city) {
        _city = city;
    }

    public void doStuff() {
        _city.doStuff();
    }
}
