package creativei.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public enum ComputerKnowledge {
        BASIC("Basic"),
        PRIOR("Prior"),
        ADVANCE("Advance"),
        NONE("None");

        private String value;

        private ComputerKnowledge(String value) {
                this.value =value;
        }

        private static final Map<String, ComputerKnowledge> lookup = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        static {
                for ( ComputerKnowledge computerKnowledge : ComputerKnowledge.values()) {
                        lookup.put(computerKnowledge.enumToString(computerKnowledge),computerKnowledge );
                }
        }

        public static String enumToString(ComputerKnowledge computerKnowledge) {
                if(computerKnowledge==null){return  null;}
                return computerKnowledge.value;
        }

        public static ComputerKnowledge stringToEnum(String value) {
                if(value==null){return  null;}
                return lookup.get(value);
        }
}
