package gradledeps.sourcegeneration;

import generators.InterfaceProperty;

public class Country implements CountryIF {
    private StateIF _state;

    public Country(StateIF state){
        _state = state;
    }
    @InterfaceProperty
    @Override
    public void doStuff() {
        _state.doStuff();
    }
}
