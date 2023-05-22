package helpers.enums;

public class ProductDetailsEnums {

    public enum ProductDetails {
        BLACK("Color: Black"),
        FIRST_NAME_COLUMN("Color: White"),
        S("Size: S");


        private final String productDetail;

        ProductDetails(String productDetail) {
            this.productDetail = productDetail;
        }

        public String getProductDetail() {
            return this.productDetail;
        }
    }
}
