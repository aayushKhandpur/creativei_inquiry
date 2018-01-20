package creativei.exception;

import creativei.enums.ExceptionType;
import creativei.helper.constant.DbConstraints;

public class InvalidParamRequest extends Exception {
    public InvalidParamRequest(String msg){super(msg);}
}
