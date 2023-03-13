package helpers.enums;

public class AlertEnums {

    public enum AlertMessages {
        AUTHENTICATION_FIELD("Authentication failed."),
        RESET_YOUR_PASSWORD("If this email address has been registered in our shop, you will receive a link to reset your password at"),
        INVALID_FORMAT("Invalid format."),
        FIRST_NAME_TOO_LONG("The first name field is too long (255 chars max)."),
        LAST_NAME_TOO_LONG("The last name field is too long (255 chars max)."),
        INVALID_DATE_FORMAT("Format should be 05/31/1970."),
        INVALID_PASSWORD("Password must be between 5 and 72 characters long"),
        ADDRESS_SUCCESSFULLY_ADDED("Address successfully added!");


        private final String alertMessage;

        AlertMessages(String alertMessage) {
            this.alertMessage = alertMessage;
        }

        public String getAlertMessage() {
            return this.alertMessage;
        }
    }

}
