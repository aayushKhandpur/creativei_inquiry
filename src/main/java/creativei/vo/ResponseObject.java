package creativei.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

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

    public Object getData() {
        return data;
    }

    public Error getException() {
        return exception;
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
        @JsonProperty("code") private int errorCode;
        @JsonProperty("message") private String message;

        @JsonCreator
        public Error(int code, String message){
            this.errorCode = code;
            this.message = message;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "errorCode=" + errorCode +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
