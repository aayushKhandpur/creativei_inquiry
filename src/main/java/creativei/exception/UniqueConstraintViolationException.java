package creativei.exception;

import creativei.helper.constant.DbConstraints;

/**
 * Created by Aayush on 12/26/2017.
 */
public class UniqueConstraintViolationException extends DataIntegrityException {
    private String field;

    private UniqueConstraintViolationException(String message, String field){
        super(message);
        this.field = field;
    }

    public static UniqueConstraintViolationException getInstance(String constraint, String message){
        switch (constraint){
            case DbConstraints.BRANCH_NAME_UNIQUE: {
                return new UniqueConstraintViolationException(DbConstraints.BRANCH_NAME_UNIQUE_MSG, DbConstraints.BRANCH_NAME);
            }
            case DbConstraints.BRANCH_MOBILE_UNIQUE: {
                return new UniqueConstraintViolationException(DbConstraints.BRANCH_MOBILE_UNIQUE_MSG, DbConstraints.BRANCH_MOBILE);
            }
            default: {
                return new UniqueConstraintViolationException(constraint, message);
            }
        }
    }
}
