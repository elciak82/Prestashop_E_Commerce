package helpers.enums;

public class CountryEnums {

    public enum Country {
        POLAND("Poland"),
        UNITED_KINGDOM("United Kingdom"),
        UNITED_STATES("United States"),
        POLAND_ID("14"),
        UNITED_KINGDOM_ID("17"),
        UNITED_STATES_ID("21");


        private final String countryEnums;

        Country(String countryEnums) {
            this.countryEnums = countryEnums;
        }
        public String getCountry() {
            return this.countryEnums;
        }
    }
}
