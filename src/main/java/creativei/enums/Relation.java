package creativei.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 12/20/2017.
 */
public enum Relation {
    FATHER("Father"),
    MOTHER("Mother"),
    UNCLE("Uncle"),
    AUNT("Aunt"),
    COUSIN("Cousin"),
    SIBLING("Sibling");

    private String value;

    private Relation(String value) {this.value = value; }

    private static final Map<String, Relation> lookup = new HashMap<String, Relation>();

    static {
        for ( Relation relation : Relation.values()) {
            lookup.put(Relation.enumToString(relation),relation );
        }
    }

    public static String enumToString(Relation relation) {
        return relation.value;
    }

    public static Relation stringToEnum(String value) {
        return lookup.get(value);
    }
}
