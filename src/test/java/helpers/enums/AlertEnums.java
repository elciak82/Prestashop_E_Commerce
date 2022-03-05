package helpers.enums;

public class AlertEnums {

    public enum AlertMessageEnums {
        INVALID_EMAIL_ADDRESS_ERROR("Invalid email address.");

        private final String alertMessage;

        AlertMessageEnums(String alertMessage) {
            this.alertMessage = alertMessage;
        }

        public String getAlertMessage() {
            return this.alertMessage;
        }
    }
}
