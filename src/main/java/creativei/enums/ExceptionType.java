package creativei.enums;

/**
 * Created by Aayush on 12/27/2017.
 */
public enum ExceptionType {
    GENERAL_ERROR(1001, "Server error"),
    DUPLICATE_VALUE(1002, "Value already exists"),
    DATABASE_EXCEPTION(1003, "Exception occured while adding values to database"),
    INVALID_METHOD_PARAM(1004,"Invalid Method Request "),
    NO_RECORD_FOUND(1005,"No Record Found"),
    DATA_NOT_AVAILABLE(400,"Invalid Inquiry Status");
    private final int code;
    private final String message;
    private ExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
