package util;

import sun.awt.geom.AreaOp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public static final Date stringToDate(String string) throws ParseException {
        if (string == null || string.isEmpty()) return null;

        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE);
        return dateFormat.parse(string);
    }

    public static final Date stringtoDateWithTime(String string) throws ParseException {
        if (string == null || string.isEmpty())
            return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_WITH_TIME);
        return dateFormat.parse(string);
    }

    public static final Date getDateWithStartingTime(Date date) throws ParseException{
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return calendar.getTime();
    }
    public static final Date getWeekStartingDate(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek= calendar.get(Calendar.DAY_OF_WEEK);
        Integer amount=dayOfWeek-Calendar.SUNDAY;
        calendar.add(Calendar.DATE,-amount+1);
        return dateFormat.parse(dateFormat.format( calendar.getTime()));
    }

    public static final Date getMonthStartingDate(Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        int dayOfMonth= calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE,-dayOfMonth+1);
        return dateFormat.parse(dateFormat.format(calendar.getTime()));
    }
}
