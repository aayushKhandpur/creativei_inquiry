package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public enum MarkScheme {
    CGPA("CGPA"),
    PERCENTAGE("Percentage"),
    TOTAL("Total");

    private String value;

    private MarkScheme(String value) {
        this.value=value;
    }

    private static final Map<String, MarkScheme> lookup = new HashMap<String,MarkScheme>();

    public static List<String> getEnumValue(){
        List<String> s= java.util.stream.Stream.of(MarkScheme.values()).map(markScheme -> markScheme.value).collect(Collectors.toList());
        return s;
    }

    static {
        for ( MarkScheme markScheme :MarkScheme.values()) {
            lookup.put(markScheme.enumToString(markScheme).toLowerCase(),markScheme );
        }
    }

    public static String enumToString(MarkScheme markScheme) {
        if(markScheme==null){return  null;}
        return markScheme.value;}

    public static MarkScheme stringToEnum(String value) {
        if(value==null){return  null;}
        return lookup.get(value.toLowerCase());
    }
}
