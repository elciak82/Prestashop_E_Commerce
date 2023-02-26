package helpers.enums;

public class ColumnNameEnums {

    public enum Columns {
        LAST_NAME_COLUMN("lastname"),
        FIRST_NAME_COLUMN("firstname"),
        EMAIL_COLUMN("email");


        private final String columnEnums;

        Columns(String columnEnums) {
            this.columnEnums = columnEnums;
        }
        public String getColumnName() {
            return this.columnEnums;
        }
    }
}
