package helpers.providers;


import org.apache.commons.exec.util.StringUtils;

import java.util.GregorianCalendar;

public class DataFactory {

    private static final String NUMERIC_STRING = "1234567890";
    private static final String ALPHA_STRING = "abcdefghijklmnoprstuvwxyz";

    public static String generateRandomBirthdate() {

        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return ((gc.get(gc.MONTH) + 1) + "/" + (gc.DAY_OF_MONTH) + "/" + gc.get(gc.YEAR));

    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public static String randomNumericString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String randomAlphaString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_STRING.length());
            builder.append(ALPHA_STRING.charAt(character));
        }
        return builder.toString();
    }

}
