package com.simplelibclient.interfacehierarchy;

public class Continent implements ContinentIF{
    private CountryIF _country;
    public Continent(CountryIF country) {
        _country = country;
    }

    @Override
    public void doStuff() {
        _country.doStuff();
    }

}
