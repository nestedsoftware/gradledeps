package gradledeps.sourcegeneration;

import generators.InterfaceProperty;
import gradledeps.sourcegeneration.pets.Pet;
import gradledeps.sourcegeneration.pets.PetIF;

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
    public void doStuff3() {
        System.out.println("hello!");
    }

    @InterfaceProperty
    @Override
    public gradledeps.sourcegeneration.pets.PetIF getPet() {
        System.out.println("hello!");
        return new Pet();
    }

}