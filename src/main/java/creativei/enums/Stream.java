package creativei.enums;

import java.util.HashMap;
import java.util.Map;

public enum Stream {

        SCIENCE("Science"),
        COMMERCE("Commerce"),
        ARTS("Arts");
        private String value;

        private Stream(String value) {
                this.value=value;
        }

        private static final Map<String, Stream> lookup = new HashMap<String, Stream>();

        static {
                for ( Stream stream: Stream.values()) {
                        lookup.put(stream.enumToString(stream),stream );
                }
        }

        public static String enumToString(Stream stream) {
                return stream.value;
        }

        public static Stream stringToEnum(String value) {
                return lookup.get(value);
        }

}
