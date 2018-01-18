package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by user on 12/20/2017.
 */
public enum EducationStatus {
    PURSUING("Pursuing"),
    COMPLETED("Completed");
    private static final Map<String, EducationStatus> lookup = new HashMap<String, EducationStatus>();

    static {
        for (EducationStatus status : EducationStatus.values()) {
            lookup.put(status.enumToString(status).toLowerCase(), status);
        }
    }

    private String value;

    private EducationStatus(String value) {
        this.value = value;
    }

    public static List<String> getEnumValue() {
        return java.util.stream.Stream.of(EducationStatus.values()).map(educationStatus -> educationStatus.value).collect(Collectors.toList());
    }

    public static String enumToString(EducationStatus status) {
        if (status == null) {
            return null;
        }
        return status.value;
    }

    public static EducationStatus stringToEnum(String value) {
        if (value == null) {
            return null;
        }
        return lookup.get(value.toLowerCase());
    }
}
