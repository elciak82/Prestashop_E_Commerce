package helpers.providers;

import helpers.models.Customer;

import java.util.Date;
import java.util.GregorianCalendar;

public class CustomerFactory {

    private static final String NUMERIC_STRING = "1234567890";
    private static final String ALPHA_STRING = "abcdefghijklmnoprstuvwxyz";
    private String suffix = generateSuffix();
    private String birthDate = generateRandomBirthdate();

    public static String generateRandomBirthdate() {

        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return ((gc.get(gc.MONTH) + 1) + "/" + (gc.DAY_OF_MONTH) + "/" + gc.get(gc.YEAR));

    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

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

    public String generateSuffix() {
        return randomAlphaString(6);
    }

    public String customerRandomFirstName() {
        return "FirstName" + suffix;
    }

    public String customerRandomLastName() {
        return "LastName" + suffix;
    }

    public String customerRandomEmail() {
        return "email@" + suffix + ".com";
    }

    public String customerRandomPassword() {
        return "pass" + suffix;
    }

    public String customerRandomBirthdate() {
        return birthDate;
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

    public Customer getCustomerToRegister_all() {
        String firstName = customerRandomFirstName();
        String lastName = customerRandomLastName();
        String password = customerRandomPassword();
        String email = customerRandomEmail();
        String birthday = customerRandomBirthdate();

        return Customer.builder()
                .customerFirstName(firstName)
                .customerLastName(lastName)
                .customerPassword(password)
                .customerEmail(email)
                .customerBirthday(birthday)
                .build();

    }
}
