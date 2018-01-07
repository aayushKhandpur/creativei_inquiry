package creativei.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by user on 12/20/2017.
 */
public enum Status {
    PURSUING("Pursuing"),
    COMPLETED("Completed");
    private String value;

    private Status(String value) {
        this.value=value;
    }

    private static final Map<String, Status> lookup = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    static {
        for ( Status status: Status.values()) {
            lookup.put(status.enumToString(status),status );
        }
    }

    public static String enumToString(Status status) {
        if(status==null){return  null;}
        return status.value;    }

    public static Status stringToEnum(String value) {
        if(value==null){return  null;}
        return lookup.get(value);
    }
}
