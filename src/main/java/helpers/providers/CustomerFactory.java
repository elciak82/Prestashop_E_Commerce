package helpers.providers;

import helpers.models.Customer;

import java.util.GregorianCalendar;

public class CustomerFactory extends DataFactory{

    private String suffix = generateSuffix();
    private String birthDate = generateRandomBirthdate();

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
