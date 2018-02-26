package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalizationUtil {

    private static final String DATE_WITH_TIME = "yyyy-MM-dd hh:mm a";
    private static final String DATE = "yyyy-MM-dd";

    public static final String getFormattedDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE);
        if (date == null || date.toString().isEmpty()) return null;
        return dateFormat.format(date);
    }

    public static final String getFormattedDateWithTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_WITH_TIME);
        if (date == null || date.toString().isEmpty()) return null;
        return dateFormat.format(date);
    }

    public static final Date stringToDateConverter(String string) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE);
        if (string == null || string.isEmpty())
            return null;
        return dateFormat.parse(string);
    }

    public static final Date stringtoDateWithTimeConverter(String string) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_WITH_TIME);
        if (string == null || string.isEmpty())
            return null;
        return dateFormat.parse(string);
    }
}
