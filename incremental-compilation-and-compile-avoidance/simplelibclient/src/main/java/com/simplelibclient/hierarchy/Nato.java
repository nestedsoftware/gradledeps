package com.simplelibclient.hierarchy;

import java.math.BigDecimal;
import java.util.List;

public class Nato {
    //does not get recompiled if we add a method to country?
    private List<Country> _countries;

    public Nato(List<Country> countries) {
        _countries = countries;
    }

    public void help() {
        for (Country c : _countries) {
            c.transferTo(new BigDecimal(100.0));
        }
    }

//    public void addCountry(Country country) {
//        _countries.add(country);
//    }
}
