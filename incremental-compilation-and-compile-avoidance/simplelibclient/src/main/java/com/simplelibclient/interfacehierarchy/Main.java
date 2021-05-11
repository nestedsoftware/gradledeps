package com.simplelibclient.interfacehierarchy;

public class Main {
    public static void main(String[] args) {
        new Continent(
                new Country(
                        new State(
                                new City()))).doStuff();
    }
}
