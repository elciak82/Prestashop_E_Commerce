package helpers.enums;

public class AlertEnums {

    public enum AlertMessages {
        AUTHENTICATION_FIELD("Authentication failed."),
        RESET_YOUR_PASSWORD("If this email address has been registered in our shop, you will receive a link to reset your password at");

        private final String alertMessage;

        AlertMessages(String alertMessage) {
            this.alertMessage = alertMessage;
        }

        public String getAlertMessage() {
            return this.alertMessage;
        }
    }
}
