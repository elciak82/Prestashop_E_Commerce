package helpers.providers;

import helpers.enums.CountryEnums;
import helpers.enums.StateEnums;
import helpers.models.Address;

public class AddressFactory extends DataFactory {

    private String suffix = generateSuffix();

    public String generateSuffix() {
        return randomAlphaString(5);
    }

    public String customerAddress() {
        return "Address" + suffix;
    }

    public String customerCity() {
        return "City" + suffix;
    }

    public String customerState(StateEnums.State state) {
        return state.getState();
    }

    public String customerZip() {
        return suffix;
    }

    public String customerCountry(CountryEnums.Country country) {
        return country.getCountry() ;
    }

    public Address getCustomerAddress_required(CountryEnums.Country country, StateEnums.State state) {
        String customerAddress = customerAddress();
        String customerCity = customerCity();
        String customerState = customerState(state);
        String customerZip = customerZip();
        String customerCountry = customerCountry(country);

        return Address.builder()
                .customerAddress(customerAddress)
                .customerCity(customerCity)
                .customerState(customerState)
                .customerZip(customerZip)
                .customerCountry(customerCountry)
                .build();
    }
}
