package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FollowUpStatus {
    CALL_BACK("To Call Back/Follow Up"),
    FOLLOW_UP_LATER("Not Interested Now/To Follow Up Later"),
    NOT_INTERESTED("Not Intersted Now/Lead Mismatch"),
    ENROLLED_W_COMPITITOR("Enrolled with competitor"),
    ENROLLED("Enrolled"),
    NOT_ELIGIBLE("Not Eligible");

    private static final Map<String, FollowUpStatus> lookup = new HashMap<String, FollowUpStatus>();

    static {
        for (FollowUpStatus followUpStatus : FollowUpStatus.values()) {
            lookup.put(FollowUpStatus.enumToString(followUpStatus).toLowerCase(), followUpStatus);
        }
    }

    private String value;

    private FollowUpStatus(String value) {
        this.value = value;
    }

    public static String enumToString(FollowUpStatus followUpStatus) {
        if (followUpStatus == null) {
            return null;
        }
        return followUpStatus.value;
    }

    public static FollowUpStatus stringToEnum(String value) {
        if (value == null) {
            return null;
        }
        return lookup.get(value.toLowerCase());
    }

    public static List<String> getEnumValue() {
        return Stream.of(FollowUpStatus.values()).map(FollowUpStatus -> FollowUpStatus.value).collect(Collectors.toList());
    }

    public String getValue() {
        return value;
    }
}
