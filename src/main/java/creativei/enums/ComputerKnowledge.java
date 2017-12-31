package creativei.enums;

public enum ComputerKnowledge {
        BASIC("Basic"),
        PRIOR("Prior"),
        ADVANCE("Advance"),
        NONE("None");

        private String computerKnowledgeValue;
        private ComputerKnowledge(String computerKnowledgeValue){
                this.computerKnowledgeValue=computerKnowledgeValue;
        }
        public static String enumToString(ComputerKnowledge computerKnowledge){
              return   computerKnowledge.computerKnowledgeValue;
        }
        public static ComputerKnowledge stringToEnum(String s){
                for(ComputerKnowledge x:ComputerKnowledge.values())
                        if(x.computerKnowledgeValue.equalsIgnoreCase(s)) return x;
                return null;

        }
}
