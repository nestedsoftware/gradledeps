package com.simplelibclient.interfacehierarchy;

public class State implements StateIF {
    private CityIF _city;

    public State(CityIF city) {
        _city = city;
    }
    @Override
    public void doStuff() {
        _city.doStuff();
    }
}
