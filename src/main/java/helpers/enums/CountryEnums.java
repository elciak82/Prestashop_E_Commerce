package helpers.enums;

public class CountryEnums {

    public enum Country {
        POLAND("Poland"),
        UNITED_KINGDOM("United Kingdom"),
        UNITED_STATES("United States");

        private final String countryEnums;

        Country(String countryEnums) {
            this.countryEnums = countryEnums;
        }
        public String getCountry() {
            return this.countryEnums;
        }
    }
}
