package helpers.enums;

public class PageTitleEnums {

    public enum TitlesEnums {
        LOGIN_PAGE("Login"),
        CONTACT_US_PAGE("Contact us"),
        CLOTHES_PAGE("Clothes"),
        HOME_PAGE("My prestashop"),
        ACCESSORIES_PAGE("Accessories"),
        ART_PAGE("Art"),
        MEN_PAGE("Men"),
        WOMEN_PAGE("Women"),
        MY_ACCOUNT_PAGE("My account");

        private final String pageTitle;

        TitlesEnums(String pageTitle) {
            this.pageTitle = pageTitle;
        }
        public String getPageTitle() {
            return this.pageTitle;
        }
    }
}
