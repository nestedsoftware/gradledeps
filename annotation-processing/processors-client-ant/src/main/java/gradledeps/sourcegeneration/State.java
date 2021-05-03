package gradledeps.sourcegeneration;

import generators.InterfaceProperty;

public class State implements StateIF {
    private CityIF _city;

    public State(CityIF city) {
        _city = city;
    }

    @InterfaceProperty
    @Override
    public void doStuff() {
        _city.doStuff();
    }

}
