package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalizationUtil {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final String getFormattedDate(Date date){
        if(date == null||date.toString().isEmpty()) return null;
        return dateFormat.format(date);
    }
    public static final Date stringToDateConverter(String string) throws ParseException{
        if(string==null||string.isEmpty())
            return null;
        return dateFormat.parse(string);
    }
}
