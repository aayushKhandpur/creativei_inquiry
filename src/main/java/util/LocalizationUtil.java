package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 12/28/2017.
 */
public class LocalizationUtil {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static final String getFormattedDate(Date date){
        if(date == null) return null;
        return dateFormat.format(date);
    }
    public static final Date stringToDateConverter(String string) throws Exception{
        return dateFormat.parse(string);
    }
}
