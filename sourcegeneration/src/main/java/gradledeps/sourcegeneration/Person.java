package gradledeps.sourcegeneration;

import generators.InterfaceProperty;

public class Person implements PersonIF {
    @InterfaceProperty
    @Override
    public void doStuff() {
        System.out.println("hello!");
    }

    @InterfaceProperty
    @Override
    public void doStuff2() {
        System.out.println("hello!");
    }

    @InterfaceProperty
    @Override
    public Poop doStuff3() {
        System.out.println("hello!");
    }

    @InterfaceProperty
    @Override
    public String doStuff4() {
        System.out.println("hello!");
    }

}