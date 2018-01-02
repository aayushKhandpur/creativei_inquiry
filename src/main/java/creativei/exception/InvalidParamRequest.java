package creativei.exception;

import creativei.enums.ExceptionType;
import creativei.helper.constant.DbConstraints;

/**
 * Created by user on 1/2/2018.
 */
public class InvalidParamRequest extends Exception {
    public InvalidParamRequest(String msg){super(msg);}
}
