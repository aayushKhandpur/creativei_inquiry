package creativei.helper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by user on 1/21/2018.
 */
public class RequestHelper {
    private static final Logger logger= LoggerFactory.getLogger(RequestHelper.class);
    public static Boolean isEmptyRequestString(String inquiryStr){
        if (StringUtils.isBlank(inquiryStr)){
            logger.error("Request data is null or empty.");
            return  true;
        }
        return false;
    }
}
