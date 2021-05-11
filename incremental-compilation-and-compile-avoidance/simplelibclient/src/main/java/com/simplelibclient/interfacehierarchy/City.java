package com.simplelibclient.interfacehierarchy;

public class City implements CityIF {
    @Override
    public void doStuff() {
        System.out.println("hello");
    }
}
