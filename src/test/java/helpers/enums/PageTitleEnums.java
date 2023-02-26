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
        FORGOT_YOUR_PASSWORD_PAGE ("Forgot your password");

        private final String pageTitle;

        Titles(String pageTitle) {
            this.pageTitle = pageTitle;
        }
        public String getPageTitle() {
            return this.pageTitle;
        }
    }
}
