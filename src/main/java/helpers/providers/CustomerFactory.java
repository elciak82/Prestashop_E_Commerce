package helpers.providers;

import helpers.models.Customer;

import java.util.GregorianCalendar;

public class CustomerFactory extends DataFactory{

    private static String suffix = generateSuffix();
    private static String birthDate = generateRandomBirthdate();

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

    public static String customerRandomBirthdate() {
        return birthDate;
    }

    public static Customer getCustomerToRegisterRequired() {
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

    public static String getCustomerFirstNameLastName(){
        return customerRandomFirstName() + " " + customerRandomLastName();
    }

    public static Customer getCustomerToRegister_all() {
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
