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

    @InterfaceProperty
    @Override
    public void doStuff2() {
        _city.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff3() {
        _city.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff4() {
        _city.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff5() {
        _city.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff6() {
        _city.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff7() {
        _city.doStuff();
    }
}
