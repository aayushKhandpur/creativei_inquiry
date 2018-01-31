package creativei.enums;

import java.util.List;
import java.util.stream.*;

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
    public static List<String> getEnumValue(){
       return java.util.stream.Stream.of(FollowUpType.values()).map(FollowUpType->FollowUpType.value).collect(Collectors.toList());
    }
}
