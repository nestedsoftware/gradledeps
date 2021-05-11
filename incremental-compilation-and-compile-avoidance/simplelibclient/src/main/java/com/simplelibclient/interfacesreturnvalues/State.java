package com.simplelibclient.interfacesreturnvalues;

public class State implements StateIF {
    private CityIF _city;

    public State(CityIF city) {
        _city = city;
    }
    @Override
    public CityIF getCity() {
        return _city;
    }
}
