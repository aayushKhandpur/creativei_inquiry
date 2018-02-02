package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public enum FollowUpSubStatus {
    MORE_COUNSELLING("Need more counselling"),
    ENROLLMENT_IN_THIRTY_DAYS("Possible enrollment in a month"),
    NOT_DECIDED("Not decided yet,will decide later"),
    NOT_REACHABLE("Not reachable"),
    MAY_JOIN_LATER("Interested to join later"),
    NOT_ELIGIBLE("Not eligible"),
    BATCH_TIMING("Batch timing not suitable"),
    FINANCIAL_INADEQUATE("Financial issue"),
    COURSE_NOT_OFFERED("Course not offered"),
    OUTSTATION("Outstation candidate"),
    DEGREE_COURSE("No degree course"),
    DEMO_CLASS("Demo class not good enough"),
    COMPETITOR_FEE_STRUCTURE("Competitor offered better fee structure"),
    COMPETITOR_INFRA("Competitor better infrastructure"),
    INFRA("Inadequate infrastructure"),
    ENROLLED("Enrolled");

    private static final Map<String, FollowUpSubStatus> lookup = new HashMap<String, FollowUpSubStatus>();

    static {
        for (FollowUpSubStatus followUpSubStatus : FollowUpSubStatus.values()) {
            lookup.put(FollowUpSubStatus.enumToString(followUpSubStatus).toLowerCase(), followUpSubStatus);
        }
    }

    private String value;

    private FollowUpSubStatus(String value) {
        this.value = value;
    }

    public static String enumToString(FollowUpSubStatus followUpSubStatus) {
        if (followUpSubStatus == null) {
            return null;
        }
        return followUpSubStatus.value;
    }

    public static FollowUpSubStatus stringToEnum(String value) {
        if (value == null) {
            return null;
        }
        return lookup.get(value.toLowerCase());
    }

    public static List<String> getEnumValue() {
        return java.util.stream.Stream.of(FollowUpSubStatus.values()).map(FollowUpSubStatus -> FollowUpSubStatus.value).collect(Collectors.toList());
    }

    public String getValue() {
        return value;
    }
}
