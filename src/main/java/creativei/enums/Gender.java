package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public enum Gender {

        MALE("Male"),
        FEMALE("Female");

        private String value;

        private Gender(String value) {
                this.value=value;
        }

        private static final Map<String, Gender> lookup = new HashMap<String,Gender>();

        public static List<String> getEnumValue(){
                List<String> s= java.util.stream.Stream.of(Gender.values()).map(Gender::name).collect(Collectors.toList());
                return s;
        }


        static {
                for ( Gender gender :Gender.values()) {
                        lookup.put(gender.enumToString(gender).toLowerCase(),gender );
                }
        }

        public static String enumToString(Gender gender) {
                if(gender==null){return  null;}
                return gender.value;
        }

        public static Gender stringToEnum(String value) {
                if(value==null){return  null;}
                return lookup.get(value.toLowerCase());
        }
}
