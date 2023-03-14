package helpers.models;

import java.security.SecureRandom;

public class Address {

    private String customerAlias;
    private String customerCompany;
    private String customerVATNumber;
    private String customerAddress;
    private String customerAddressComplement;
    private String customerCity;
    private String customerState;
    private String customerZip;
    private String customerCountry;
    private String customerPhone;

    public Address() {
    }

    public String getCustomerAlias() {
        return customerAlias;
    }

    public void setCustomerAlias(String customerAlias) {
        this.customerAlias = customerAlias;
    }

    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    public String getCustomerVATNumber() {
        return customerVATNumber;
    }

    public void setCustomerVATNumber(String customerVATNumber) {
        this.customerVATNumber = customerVATNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAddressComplement() {
        return customerAddressComplement;
    }

    public void setCustomerAddressComplement(String customerAddressComplement) {
        this.customerAddressComplement = customerAddressComplement;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public static final class Builder {
        private String customerAlias;
        private String customerCompany;
        private String customerVATNumber;
        private String customerAddress;
        private String customerAddressComplement;
        private String customerCity;
        private String customerState;
        private String customerZip;
        private String customerCountry;
        private String customerPhone;

        public Builder customerAlias(String customerAlias) {
            this.customerAlias = customerAlias;
            return this;
        }

        public Builder customerCompany(String customerCompany) {
            this.customerCompany = customerCompany;
            return this;
        }

        public Builder customerVATNumber(String customerVATNumber) {
            this.customerVATNumber = customerVATNumber;
            return this;
        }

        public Builder customerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }

        public Builder customerAddressComplement(String customerAddressComplement) {
            this.customerAddressComplement = customerAddressComplement;
            return this;
        }

        public Builder customerCity(String customerCity) {
            this.customerCity = customerCity;
            return this;
        }

        public Builder customerState(String customerState) {
            this.customerState = customerState;
            return this;
        }

        public Builder customerZip(String customerZip) {
            this.customerZip = customerZip;
            return this;
        }

        public Builder customerCountry(String customerCountry) {
            this.customerCountry = customerCountry;
            return this;
        }

        public Builder customerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
            return this;
        }

        public Address build() {
            Address address = new Address();
            address.customerAlias = this.customerAlias;
            address.customerCompany = this.customerCompany;
            address.customerVATNumber = this.customerVATNumber;
            address.customerAddress = this.customerAddress;
            address.customerAddressComplement = this.customerAddressComplement;
            address.customerCity = this.customerCity;
            address.customerState = this.customerState;
            address.customerZip = this.customerZip;
            address.customerCountry = this.customerCountry;
            address.customerPhone = this.customerPhone;
            return address;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
