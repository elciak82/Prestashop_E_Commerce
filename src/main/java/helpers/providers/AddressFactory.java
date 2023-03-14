package helpers.providers;

import helpers.enums.CountryEnums;
import helpers.enums.StateEnums;
import helpers.models.Address;

public class AddressFactory extends DataFactory {

    private String suffix = generateSuffix();
    private String number = randomNumericString(5);

    public String generateSuffix() {
        return randomAlphaString(5);
    }

    public String customerAlias() { return "Alias" + suffix; }

    public String customerCompany() { return "Company" + suffix; }

    public String customerVatNumber() { return number; }

    public String customerAddress() {
        return "Address" + suffix;
    }

    public String customerAddressComplement() { return "AddressComplement" + suffix; }

    public String customerCity() {
        return "City" + suffix;
    }

    public String customerState(StateEnums.State state) {
        return state.getState();
    }

    public String customerZip() {
        return number;
    }

    public String customerCountry(CountryEnums.Country country) {
        return country.getCountry() ;
    }

    public String customerPhone() { return number; }

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

    public Address getCustomerAddress_allForUnitedStates(StateEnums.State state) {
        String customerAlias = customerAlias();
        String customerCompany = customerCompany();
        String customerAddress = customerAddress();
        String customerAddressComplement = customerAddressComplement();
        String customerCity = customerCity();
        String customerState = customerState(state);
        String customerZip = customerZip();
        String customerCountry = customerCountry(CountryEnums.Country.UNITED_STATES);
        String customerPhone = customerPhone();


        return Address.builder()
                .customerAlias(customerAlias)
                .customerCompany(customerCompany)
                .customerAddress(customerAddress)
                .customerAddressComplement(customerAddressComplement)
                .customerCity(customerCity)
                .customerState(customerState)
                .customerZip(customerZip)
                .customerCountry(customerCountry)
                .customerPhone(customerPhone)
                .build();
    }

    public Address getCustomerAddress(CountryEnums.Country country,StateEnums.State state) {
        String customerAlias = customerAlias();
        String customerCompany = customerCompany();
        String customerVatNumber = customerVatNumber();
        String customerAddress = customerAddress();
        String customerAddressComplement = customerAddressComplement();
        String customerCity = customerCity();
        String customerState = customerState(state);
        String customerZip = customerZip();
        String customerCountry = customerCountry(CountryEnums.Country.UNITED_STATES);
        String customerPhone = customerPhone();


        return Address.builder()
                .customerAlias(customerAlias)
                .customerCompany(customerCompany)
                .customerVATNumber(customerVatNumber)
                .customerAddress(customerAddress)
                .customerAddressComplement(customerAddressComplement)
                .customerCity(customerCity)
                .customerState(customerState)
                .customerZip(customerZip)
                .customerCountry(customerCountry)
                .customerPhone(customerPhone)
                .build();
    }
}
