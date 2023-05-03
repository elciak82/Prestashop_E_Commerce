package helpers.enums;

public class PageTitleEnums {

    public enum Titles {
        LOGIN_PAGE("Login"),
        CONTACT_US_PAGE("Contact us"),
        CLOTHES_PAGE("Clothes"),
        HOME_PAGE("My prestashop"),
        ACCESSORIES_PAGE("Accessories"),
        ART_PAGE("Art"),
        MEN_PAGE("Men"),
        WOMEN_PAGE("Women"),
        MY_ACCOUNT_PAGE("My account"),
        FORGOT_YOUR_PASSWORD_PAGE ("Forgot your password"),
        PRICES_DROP_PAGE ("Prices drop"),
        NEW_PRODUCTS_PAGE ("New products"),
        BEST_SALES_PAGE ("Best sales"),
        DELIVERY_PAGE ("Delivery"),
        LEGAL_NOTICE_PAGE ("Legal Notice"),
        TERMS_AND_CONDITIONS_PAGE ("Terms and conditions of use"),
        ABOUT_US_PAGE ("About us"),
        SECURE_PAYMENT_PAGE ("Secure payment"),
        SITEMAP_PAGE ("Sitemap"),
        STORES_PAGE ("Stores"),
        PERSONAL_INFO_PAGE ("Identity"),
        ORDERS_PAGE ("Order history"),
        CREDIT_SLIPS_PAGE ("Credit slip"),
        ADDRESSES_PAGE ("Addresses"),
        WISHLIST_PAGE ("My prestashop");

        private final String pageTitle;

        Titles(String pageTitle) {
            this.pageTitle = pageTitle;
        }

        public String getPageTitle() {
            return this.pageTitle;
        }
    }
}
