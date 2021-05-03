package gradledeps.sourcegeneration;

import generators.InterfaceProperty;

public class Continent implements ContinentIF {
    private CountryIF _country;

    public Continent(CountryIF country) {
        _country = country;
    }

    @InterfaceProperty
    @Override
    public void doStuff() {
        _country.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff2() {
        _country.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff3() {
        _country.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff4() {
        _country.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff5() {
        _country.doStuff();
    }

    @InterfaceProperty
    @Override
    public void doStuff6() {
        _country.doStuff();
    }
}
