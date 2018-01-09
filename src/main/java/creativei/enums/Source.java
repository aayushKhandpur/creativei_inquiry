package creativei.enums;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by user on 12/20/2017.
 */
public enum Source {
    NEWSPAPER("Newspaper"),
    INTERNET("Internet"),
    APTECH_STUDENT("Aptech Student"),
    BANNER_HOARDING("Banner Hoarding"),
    FRIEND("Friend"),
    RELATIVE("Relative"),
    ANY_OTHER("Any Other");

    private String value;

    private Source(String value) {this.value = value; }

    private static final Map<String, Source> lookup = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    static {
        for ( Source source : Source.values()) {
            lookup.put(Source.enumToString(source),source );
        }
    }

    public static String enumToString(Source source) {
        if(source==null){return  null;}
        return source.value;
    }

    public static Source stringToEnum(String value) {
        if(value==null){return  null;}
        return lookup.get(value);
    }
}
