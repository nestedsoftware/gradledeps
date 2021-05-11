package gradledeps.sourcegeneration;

import generators.InterfaceProperty;

public class City implements CityIF {
    @InterfaceProperty
    @Override
    public void doStuff() {
        System.out.println("hello!");
    }
}