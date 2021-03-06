package creativei.enums;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public enum Relation {
    FATHER("Father"),
    MOTHER("Mother"),
    UNCLE("Uncle"),
    AUNT("Aunt"),
    COUSIN("Cousin"),
    SIBLING("Sibling");

    private static final Map<String, Relation> lookup = new HashMap<String, Relation>();

    static {
        for (Relation relation : Relation.values()) {
            lookup.put(Relation.enumToString(relation).toLowerCase(), relation);
        }
    }

    private String value;

    private Relation(String value) {
        this.value = value;
    }

    public static List<String> getEnumValue() {
        return java.util.stream.Stream.of(Relation.values()).map(relation -> relation.value).collect(Collectors.toList());
    }

    public static String enumToString(Relation relation) {
        if (relation == null) {
            return null;
        }
        return relation.value;
    }

    public static Relation stringToEnum(String value) {
        if (value == null) {
            return null;
        }
        return lookup.get(value.toLowerCase());
    }
}
