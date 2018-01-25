package creativei.enums;

public enum FollowUpType {
    CALL("Call"),
    SMS("SMS"),
    F2F("F2F"),
    EMAIL("Email");

    private String value;

    private FollowUpType(String value){
        this.value=value;
    }

}
