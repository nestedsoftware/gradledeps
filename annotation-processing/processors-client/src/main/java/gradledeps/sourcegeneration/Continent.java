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
}
