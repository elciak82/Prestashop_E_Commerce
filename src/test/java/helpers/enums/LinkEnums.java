package helpers.enums;

public class LinkEnums {

    public enum SuiteLinks {
        PAGE_TITLES_SUITE("https://app.qase.io/project/PRESTASHOP?view=1&suite=1&");
        String linkToCase;

        SuiteLinks(String linkToCase) {
            this.linkToCase = linkToCase;
        }

        public String getLinkToCase() {
            return this.linkToCase;
        }
    }
}
