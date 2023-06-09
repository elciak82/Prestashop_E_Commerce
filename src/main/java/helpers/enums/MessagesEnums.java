package helpers.enums;

public class MessagesEnums {

    public enum Messages {
        AUTHENTICATION_FIELD("Authentication failed."),
        RESET_YOUR_PASSWORD("If this email address has been registered in our shop, you will receive a link to reset your password at"),
        INVALID_FORMAT("Invalid format."),
        FIRST_NAME_TOO_LONG("The first name field is too long (255 chars max)."),
        LAST_NAME_TOO_LONG("The last name field is too long (255 chars max)."),
        INVALID_DATE_FORMAT("Format should be 05/31/1970."),
        INVALID_PASSWORD("Password must be between 5 and 72 characters long"),
        ADDRESS_SUCCESSFULLY_ADDED("Address successfully added!"),
        ORDER_CONFIRMED("YOUR ORDER IS CONFIRMED");


        private final String message;

        Messages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

}
