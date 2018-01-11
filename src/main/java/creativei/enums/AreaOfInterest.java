package creativei.enums;

import java.awt.geom.Area;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
            lookup.put(areaOfInterest.enumToString(areaOfInterest).toLowerCase(),areaOfInterest );
        }
    }

    public static String enumToString(AreaOfInterest areaOfInterest) {
        if (areaOfInterest == null) {return null;}

        return areaOfInterest.value;
    }
    public static AreaOfInterest stringToEnum(String value) {
        if(value==null){return  null;}

        return lookup.get(value.toLowerCase());
    }
}