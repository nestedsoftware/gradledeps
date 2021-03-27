package gradledeps.sourcegeneration.pets;

import generators.InterfaceProperty;
import gradledeps.sourcegeneration.Person;

public class Pet implements PetIF {
    @InterfaceProperty
    @Override
    public gradledeps.sourcegeneration.PersonIF getPerson() {
        System.out.println("hello!");
        return new Person();
    }
}
