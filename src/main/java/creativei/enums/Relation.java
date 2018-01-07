package creativei.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

    private static final Map<String, Relation> lookup = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    static {
        for ( Relation relation : Relation.values()) {
            lookup.put(Relation.enumToString(relation),relation );
        }
    }

    public static String enumToString(Relation relation) {
        if(relation==null){return  null;}
        return relation.value;
    }

    public static Relation stringToEnum(String value) {
        if(value==null){return  null;}
        return lookup.get(value);
    }
}
