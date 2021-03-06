package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public enum Stream {

    SCIENCE("Science"),
    COMMERCE("Commerce"),
    ARTS("Arts");
    private static final Map<String, Stream> lookup = new HashMap<String, Stream>();

    static {
        for (Stream stream : Stream.values()) {
            lookup.put(stream.enumToString(stream).toLowerCase(), stream);
        }
    }

    private String value;

    private Stream(String value) {
        this.value = value;
    }

    public static List<String> getEnumValue() {
        return java.util.stream.Stream.of(Stream.values()).map(stream -> stream.value).collect(Collectors.toList());
    }

    public static String enumToString(Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream.value;
    }

    public static Stream stringToEnum(String value) {
        if (value == null) {
            return null;
        }
        return lookup.get(value.toLowerCase());
    }

}
