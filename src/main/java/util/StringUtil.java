package util;


import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    public static String validateVo(String data){
        if(StringUtils.isBlank(data)) {
            return null;
        }
        return data;
    }
}
