package helpers.providers;

import java.util.Date;

public class CustomerFactory {

    private static final String NUMERIC_STRING = "1234567890";
    private static final String ALPHA_STRING = "abcdefghijklmnoprstuvwxyz";
    private String suffix = generateSuffix();

    public String randomNumericString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String randomAlphaString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_STRING.length());
            builder.append(ALPHA_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String generateSuffix() {
        return randomAlphaString(6);
    }

    public String customerRandomEmail() {
        return "email@" + suffix + ".com";
    }

    public String customerRandomPassword() {
        return "pass" + suffix;
    }

    public String customerRandomFirstName() {
        return "FirstName" + suffix;
    }

    public String customerRandomLastName() {
        return "LastName" + suffix;
    }

//    public Date customerRandomCompany() {
//        return "Company" + suffix;
//    }
}
