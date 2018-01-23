package creativei.enums;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum EducationType {
    DISTANCE("Distance"),
    REGULAR("Regular");

    private String value;
    private static final Map<String, EducationType> lookup = new HashMap<String, EducationType>();

    private  EducationType(String value){this.value=value;}

    static {
        for (EducationType educationType : EducationType.values()) {
            lookup.put(educationType.enumToString(educationType).toLowerCase(), educationType);
        }
    }

    public static List<String> getEnumValue() {
        return java.util.stream.Stream.of(EducationType.values()).map(educationType -> educationType.value).collect(Collectors.toList());
    }

    public static String enumToString(EducationType educationType) {
        if (educationType == null) {
            return null;
        }
        return educationType.value;
    }

    public static EducationType stringToEnum(String value) {
        if (value == null) {
            return null;
        }
        return lookup.get(value.toLowerCase());
    }

}
