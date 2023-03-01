package helpers.models;

public class Customer {

    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerPassword;
    private String customerBirthday;

    public Customer() {
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public static final class Builder {
        private String customerFirstName;
        private String customerLastName;
        private String customerEmail;
        private String customerPassword;
        private String customerBirthday;

        public Builder customerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
            return this;
        }

        public Builder customerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
            return this;
        }

        public Builder customerPassword(String customerPassword) {
            this.customerPassword = customerPassword;
            return this;
        }

        public Builder customerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder customerBirthday(String customerBirthday) {
            this.customerBirthday = customerBirthday;
            return this;
        }

        public Customer build() {
            if (customerFirstName.isEmpty()) {
                throw new IllegalStateException("First name cannot be empty");
            }
            if (customerLastName.isEmpty()) {
                throw new IllegalStateException("Last name cannot be empty");
            }

            Customer customer = new Customer();
            customer.customerFirstName = this.customerFirstName;
            customer.customerLastName = this.customerLastName;
            customer.customerEmail = this.customerEmail;
            customer.customerPassword = this.customerPassword;
            customer.customerBirthday = this.customerBirthday;
            return customer;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
