package helpers.enums;

public class NotificationEnums {

    public enum Notifications {
        LIST_TITLE_IS_TOO_SHORT("List title is too short"),
        LIST_HAS_BEEN_PROPERLY_CREATED("The list has been properly created");

        private final String notification;

        Notifications(String notification) {
            this.notification = notification;
        }

        public String getNotification() {
            return this.notification;
        }
    }

}
