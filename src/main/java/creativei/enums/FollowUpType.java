package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public enum FollowUpType {
    CALL("Call"),
    SMS("Text Message"),
    F2F("Face to Face"),
    EMAIL("Email");

    private static final Map<String, FollowUpType> lookup = new HashMap<String, FollowUpType>();

    static {
        for (FollowUpType followUpType : FollowUpType.values()) {
            lookup.put(FollowUpType.enumToString(followUpType).toLowerCase(), followUpType);
        }
    }

    private String value;

    private FollowUpType(String value) {
        this.value = value;
    }

    public static String enumToString(FollowUpType followUpType) {
        if (followUpType == null) {
            return null;
        }
        return followUpType.value;
    }

    public static FollowUpType stringToEnum(String value) {
        if (value == null) {
            return null;
        }
        return lookup.get(value.toLowerCase());
    }

    public static List<String> getEnumValue() {
        return java.util.stream.Stream.of(FollowUpType.values()).map(FollowUpType -> FollowUpType.value).collect(Collectors.toList());
    }

    public String getValue() {
        return value;
    }

}
