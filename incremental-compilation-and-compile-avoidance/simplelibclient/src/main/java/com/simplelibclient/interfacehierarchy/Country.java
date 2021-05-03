package com.simplelibclient.interfacehierarchy;

public class Country implements CountryIF {
    private StateIF _state;

    public Country(StateIF state) {
        _state = state;
    }

    @Override
    public void doStuff() {
        _state.doStuff();
    }
}
