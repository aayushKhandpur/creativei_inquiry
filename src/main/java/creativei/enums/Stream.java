package creativei.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public enum Stream {

        SCIENCE("Science"),
        COMMERCE("Commerce"),
        ARTS("Arts");
        private String value;

        private Stream(String value) {
                this.value=value;
        }

        private static final Map<String, Stream> lookup = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        static {
                for ( Stream stream: Stream.values()) {
                        lookup.put(stream.enumToString(stream),stream );
                }
        }

        public static String enumToString(Stream stream)
        {  if(stream==null){return  null;}
                return stream.value;
        }

        public static Stream stringToEnum(String value) {
                if(value==null){return  null;}
                return lookup.get(value);
        }

}
