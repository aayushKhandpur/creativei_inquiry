package creativei.vo;

/**
 * Created by Aayush on 12/16/2017.
 */
public class ResponseObject {
    public enum ResponseStatus {
        SUCCESS,
        ERROR
    }

    private Object data;
    private Error exception;
    private ResponseStatus status;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    private ResponseObject(Object data, ResponseStatus status){
        this.data = data;
        this.status = status;
    }
    private ResponseObject(String exceptionMessage, int errorCode, ResponseStatus status){
        this.exception = new Error(errorCode, exceptionMessage);
        this.status = status;
    }

    public static ResponseObject getResponse(Object data){
        return new ResponseObject(data, ResponseStatus.SUCCESS);
    }

    public static ResponseObject getResponse(String message, int errorCode){
        return new ResponseObject(message, errorCode, ResponseStatus.ERROR);
    }


    private class Error {
        private int errorCode;
        private String message;
        private String stackTrace;

        Error(int code, String message){
            this.errorCode = code;
            this.message = message;
        }
    }
}
