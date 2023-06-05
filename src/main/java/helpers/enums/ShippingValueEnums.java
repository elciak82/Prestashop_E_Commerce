package helpers.enums;

public class ShippingValueEnums {

    public enum ShippingValue {
        MY_CHEAP_CARRIER("Free"),
        MY_LIGHT_CARRIER_US("$2.00"),
        MY_LIGHT_CARRIER_PL("$2.46"),
        MY_CARRIER("$7.00");


        private final String shippingValue;

        ShippingValue(String shippingValue) {
            this.shippingValue = shippingValue;
        }
        public String getShippingValue() {
            return this.shippingValue;
        }
    }
}
