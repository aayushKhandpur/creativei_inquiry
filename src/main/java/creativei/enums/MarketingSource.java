package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by user on 12/20/2017.
 */
public enum MarketingSource {
    NEWSPAPER("Newspaper"),
    INTERNET("Internet"),
    APTECH_STUDENT("Aptech student"),
    BANNER_HOARDING("Banner Hoarding"),
    FRIEND("Freind"),
    RELATIVE("Relative"),
    OTHER("Other");

    private static final Map<String, MarketingSource> lookup = new HashMap<String, MarketingSource>();

    static {
        for (MarketingSource marketingSource : MarketingSource.values()) {
            lookup.put(marketingSource.enumToString(marketingSource).toLowerCase(), marketingSource);
        }
    }

    private String value;

    private MarketingSource(String value) {
        this.value = value;
    }

    public static List<String> getEnumValue() {
        return java.util.stream.Stream.of(MarketingSource.values()).map(marketingSource -> marketingSource.value).collect(Collectors.toList());
    }

    public static String enumToString(MarketingSource marketingSource) {
        if (marketingSource == null) {
            return null;
        }
        return marketingSource.value;
    }

    public static MarketingSource stringToEnum(String value) {
        if (value == null) {
            return null;
        }
        return lookup.get(value.toLowerCase());
    }
}
