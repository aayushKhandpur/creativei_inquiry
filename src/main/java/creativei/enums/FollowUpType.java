package creativei.enums;

public enum FollowUpType {
    CALL("Call"),
    SMS("Text Message"),
    F2F("Face to Face"),
    EMAIL("Email");

    private String value;

    private FollowUpType(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
