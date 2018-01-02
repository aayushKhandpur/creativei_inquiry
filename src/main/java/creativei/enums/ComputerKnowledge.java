package creativei.enums;

import java.util.HashMap;
import java.util.Map;

public enum ComputerKnowledge {
        BASIC("Basic"),
        PRIOR("Prior"),
        ADVANCE("Advance"),
        NONE("None");

        private String value;

        private ComputerKnowledge(String value) {
                this.value =value;
        }

        private static final Map<String, ComputerKnowledge> lookup = new HashMap<String, ComputerKnowledge>();

        static {
                for ( ComputerKnowledge computerKnowledge : ComputerKnowledge.values()) {
                        lookup.put(computerKnowledge.enumToString(computerKnowledge),computerKnowledge );
                }
        }

        public static String enumToString(ComputerKnowledge computerKnowledge) {
                return computerKnowledge.value;
        }

        public static ComputerKnowledge stringToEnum(String value) {
                return lookup.get(value);
        }
}
