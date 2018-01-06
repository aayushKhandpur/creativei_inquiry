package creativei.enums;

import java.util.HashMap;
import java.util.Map;

public enum MarkScheme {
    CGPA("CGPA"),
    PERCENTAGE("Percentage"),
    TOTAL("Total");

    private String value;

    private MarkScheme(String value) {
        this.value=value;
    }

    private static final Map<String, MarkScheme> lookup = new HashMap<String, MarkScheme>();

    static {
        for ( MarkScheme markScheme :MarkScheme.values()) {
            lookup.put(markScheme.enumToString(markScheme),markScheme );
        }
    }

    public static String enumToString(MarkScheme markScheme) { return markScheme.value;}

    public static MarkScheme stringToEnum(String value) {
        return lookup.get(value);
    }
}
