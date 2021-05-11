package com.simplelibclient.interfacesreturnvalues;

public class Country implements CountryIF {
    private StateIF _state;

    public Country(StateIF state) {
        _state = state;
    }

    @Override
    public StateIF getState() {
        return _state;
    }
}
