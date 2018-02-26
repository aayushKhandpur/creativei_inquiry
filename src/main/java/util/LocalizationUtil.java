package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalizationUtil {

    public static final String getFormattedDate(Date date,String stringDate){
        SimpleDateFormat dateFormat=new SimpleDateFormat(stringDate);
        if(date == null||date.toString().isEmpty()) return null;
        return dateFormat.format(date);
    }
    public static final Date stringToDateConverter(String string,String stringDate) throws ParseException{
        SimpleDateFormat dateFormat=new SimpleDateFormat(stringDate);
        if(string==null||string.isEmpty())
            return null;
        return dateFormat.parse(string);
    }
}
