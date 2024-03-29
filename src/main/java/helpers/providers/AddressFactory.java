package helpers.providers;

import helpers.enums.CountryEnums;
import helpers.enums.StateEnums;
import helpers.models.Address;

public class AddressFactory extends DataFactory {

    private static String suffix = generateSuffix();
    private static String number = randomNumericString(5);
    private static String numberPL = randomNumericString(2) + "-" + randomNumericString(3);

    public static String generateSuffix() {
        return randomAlphaString(5);
    }

    public static String customerAlias() {
        return "Alias" + suffix;
    }

    public static String customerCompany() {
        return "Company" + suffix;
    }

    public static String customerVatNumber() {
        return number;
    }

    public static String customerAddress() {
        return "Address" + suffix;
    }

    public static String customerAddressComplement() {
        return "AddressComplement" + suffix;
    }

    public static String customerCity() {
        return "City" + suffix;
    }

    public static String customerState(StateEnums.State state) {
        return state.getState();
    }

    public static String customerZip() {
        return number;
    }

    public static String customerZipForPoland() {
        return numberPL;
    }

    public static String customerCountry(CountryEnums.Country country) {
        return country.getCountry();
    }

    public static String customerPhone() {
        return number;
    }

    public static Address getCustomerAddressWithRequiredFields(CountryEnums.Country country, StateEnums.State state) {
        String customerAddress = customerAddress();
        String customerCity = customerCity();
        String customerState = customerState(state);
        String customerZip = customerZip();
        String customerZipForPoland = customerZipForPoland();
        String customerCountry = customerCountry(country);

        return Address.builder()
                .customerAddress(customerAddress)
                .customerCity(customerCity)
                .customerState(customerState)
                .customerZip(customerZip)
                .customerCountry(customerCountry)
                .build();
    }

    public static Address getCustomerAddressWithRequiredFieldsForPoland(CountryEnums.Country country) {
        String customerAddress = customerAddress();
        String customerCity = customerCity();
        String customerZipForPoland = customerZipForPoland();
        String customerCountry = customerCountry(country);

        return Address.builder()
                .customerAddress(customerAddress)
                .customerCity(customerCity)
                .customerZipForPoland(customerZipForPoland)
                .customerCountry(customerCountry)
                .build();
    }

    public static Address getCustomerAddress_allForUnitedStates(StateEnums.State state) {
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

    public static Address getCustomerAddress(CountryEnums.Country country, StateEnums.State state) {
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
