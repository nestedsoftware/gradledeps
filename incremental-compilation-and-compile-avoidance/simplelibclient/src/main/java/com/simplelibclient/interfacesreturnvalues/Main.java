package com.simplelibclient.interfacesreturnvalues;

public class Main {
    public static void main(String[] args) {
        new Continent(new Country(new State(new City()))).getCountry().getState().getCity().doStuff();
    }
}
