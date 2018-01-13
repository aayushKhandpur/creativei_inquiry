package creativei.enums;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public enum ComputerKnowledge {
        BASIC("Basic"),
        PRIOR("Prior"),
        ADVANCE("Advance"),
        NONE("None");

        private String value;

        private ComputerKnowledge(String value) {
                this.value =value;
        }

        private static final Map<String, ComputerKnowledge> lookup = new HashMap<String,ComputerKnowledge>();

        public static List<String> getEnumValue(){
                List<String> s= java.util.stream.Stream.of(ComputerKnowledge.values()).map(ComputerKnowledge::name).collect(Collectors.toList());
                return s;
        }


        static {
                for ( ComputerKnowledge computerKnowledge : ComputerKnowledge.values()) {
                        lookup.put(computerKnowledge.enumToString(computerKnowledge).toLowerCase(),computerKnowledge );
                }
        }

        public static String enumToString(ComputerKnowledge computerKnowledge) {
                if(computerKnowledge==null){return  null;}
                return computerKnowledge.value;
        }

        public static ComputerKnowledge stringToEnum(String value) {
                if(value==null){return  null;}
                return lookup.get(value.toLowerCase());
        }
}
