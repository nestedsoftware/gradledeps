package com.simplelibclient.hierarchy;

import com.simplelib.ExternalCountry;

public class Continent {
    private Country _country;

    public Continent(Country country) {
        _country = country;
    }

    public void doStuff() {
        _country.doStuff();
    }

    public void doStuff2() {
        _country.doStuff();
    }
}
