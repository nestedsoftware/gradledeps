package gradledeps.sourcegeneration.pets;

import generators.InterfaceProperty;

public class Pet {
    @InterfaceProperty
    @Override
    public void iAmCool() {
        System.out.println("hello!");
    }
}
