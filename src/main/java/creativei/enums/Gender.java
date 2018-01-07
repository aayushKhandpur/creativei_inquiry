package creativei.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by user on 12/20/2017.
 */
public enum Gender {

        MALE("Male"),
        FEMALE("Female");

        private String value;

        private Gender(String value) {
                this.value=value;
        }

        private static final Map<String, Gender> lookup = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        static {
                for ( Gender gender :Gender.values()) {
                        lookup.put(gender.enumToString(gender),gender );
                }
        }

        public static String enumToString(Gender gender) {
                if(gender==null){return  null;}
                return gender.value;
        }

        public static Gender stringToEnum(String value) {
                if(value==null){return  null;}
                return lookup.get(value);
        }
}
