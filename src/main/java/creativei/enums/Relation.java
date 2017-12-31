package creativei.enums;

/**
 * Created by user on 12/20/2017.
 */
public enum Relation {
    FATHER("Father"),
    MOTHER("Mother"),
    UNCLE("Uncle"),
    AUNT("Aunt"),
    COUSIN("Cousin"),
    SIBLING("Sibling");

    private String relationValue;
    private Relation(String relationValue){
        this.relationValue=relationValue;
    }
    public static String enumToString(Relation relation){
        return relation.relationValue;
    }
    public static Relation stringToEnum(String s){
        for(Relation x:Relation.values())
            if(x.relationValue.equalsIgnoreCase(s)) return x;

        return null;
    }
}
