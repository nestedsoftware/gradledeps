package gradledeps.sourcegeneration.pets;

import generators.InterfaceProperty2;

public class Pet implements PetIF {
    @InterfaceProperty2
    @Override
    public String sayHello() {
        System.out.println("hello!");
        return "hello";
    }
}
