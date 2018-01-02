package creativei.enums;

import java.util.HashMap;
import java.util.Map;

public enum  AreaOfInterest {
    WEB_DESIGNING("Web Designing"),
    VFX("VFX"),
    WEB_DEVELOPMENT("Web Development");

    private String value;

    private AreaOfInterest(String value) {
        this.value =value;
    }

    private static final Map<String, AreaOfInterest> lookup = new HashMap<String, AreaOfInterest>();

    static {
        for ( AreaOfInterest areaOfInterest : AreaOfInterest.values()) {
            lookup.put(areaOfInterest.enumToString(areaOfInterest),areaOfInterest );
        }
    }

    public static String enumToString(AreaOfInterest areaOfInterest) {
        return areaOfInterest.value;
    }

    public static AreaOfInterest stringToEnum(String value) {
        return lookup.get(value);
    }
    }