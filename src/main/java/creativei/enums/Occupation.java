package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Created by user on 12/20/2017.
 */
public enum Occupation {

    STUDENT("Student"),
    SERVICE("Service"),
    BUSINESS("Business"),
    PROFESSIONAL("Professional"),
    HOUSEWIFE("House Wife");

    private static final Map<String, Occupation> lookup = new HashMap<String, Occupation>();

    static {
        for (Occupation occupation : Occupation.values()) {
            lookup.put(occupation.enumToString(occupation).toLowerCase(), occupation);
        }
    }

    private String value;

    private Occupation(String value) {
        this.value = value;
    }

    public static List<String> getEnumValue() {
        return java.util.stream.Stream.of(Occupation.values()).map(occupation -> occupation.value).collect(Collectors.toList());
    }

    public static String enumToString(Occupation occupation) {
        if (occupation == null) {
            return null;
        }
        return occupation.value;
    }

    public static Occupation stringToEnum(String value) {
        if (value == null) {
            return null;
        }
        return lookup.get(value.toLowerCase());
    }
}


