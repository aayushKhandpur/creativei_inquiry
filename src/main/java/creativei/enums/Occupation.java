package creativei.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 12/20/2017.
 */
public enum Occupation {

        STUDENT("Student"),
        SERVICE("Service"),
        BUSINESS("Business"),
        PROFESSIONAL("Professional"),
        HOUSEWIFE("House Wife");

        private String value;

        private Occupation(String value) {
                this.value = value;
        }

        private static final Map<String, Occupation> lookup = new HashMap<String, Occupation>();

        static {
                for ( Occupation occupation : Occupation.values()) {
                        lookup.put(occupation.enumToString(occupation),occupation );
                }
        }

        public static String enumToString(Occupation occupation) {
                return occupation.value;
        }

        public static Occupation stringToEnum(String value) {
                return lookup.get(value);
        }
    }


