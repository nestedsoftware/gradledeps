package gradledeps.sourcegeneration.pets;

import generators.InterfaceProperty2;
import gradledeps.sourcegeneration.Person;

public class Pet implements PetIF {
    @InterfaceProperty2
    @Override
    public gradledeps.sourcegeneration.PersonIF getPerson() {
        System.out.println("hello!");
        return new Person();
    }
}
