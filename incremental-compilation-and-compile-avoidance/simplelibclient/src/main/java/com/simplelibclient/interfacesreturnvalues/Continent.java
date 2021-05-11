package com.simplelibclient.interfacesreturnvalues;

public class Continent implements ContinentIF {
    private CountryIF _country;
    public Continent(CountryIF country) {
        _country = country;
    }

    @Override
    public CountryIF getCountry() {
        return _country;
    }

}
