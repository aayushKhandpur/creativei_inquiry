package creativei.util;


import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    public static String validateEmpty(String data){
        if(StringUtils.isBlank(data)) {
            return null;
        }
        return data;
    }
}
