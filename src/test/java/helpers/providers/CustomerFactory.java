package helpers.providers;

import helpers.models.Customer;

import java.util.Date;

public class CustomerFactory {

    private static final String NUMERIC_STRING = "1234567890";
    private static final String ALPHA_STRING = "abcdefghijklmnoprstuvwxyz";
    private static String suffix = generateSuffix();

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

    public static String customerRandomFirstName() {
        return "FirstName" + suffix;
    }

    public static String customerRandomLastName() {
        return "LastName" + suffix;
    }

    public static String customerRandomEmail() {
        return "email@" + suffix + ".com";
    }

    public static String customerRandomPassword() {
        return "pass" + suffix;
    }

    public Customer getCustomerToRegister_required() {
        String firstName = customerRandomFirstName();
        String lastName = customerRandomLastName();
        String password = customerRandomPassword();
        String email = customerRandomEmail();

        return Customer.builder()
                .customerFirstName(firstName)
                .customerLastName(lastName)
                .customerPassword(password)
                .customerEmail(email)
                .build();
    }

    public String getCustomerFirstNameLastName(){
        return customerRandomFirstName() + " " + customerRandomLastName();
    }
}
