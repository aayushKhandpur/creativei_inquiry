package creativei.enums;

public enum CaseIndex {
    UNLIKELY("Unlikely",1),
    INTERESTED("Intersted",2),
    LIKELY("Likely",3),
    HOT_LEAD("Hot Lead",4);

    private int index;
    private String value;
    private CaseIndex(String value,int index){
        this.value=value;
        this.index=index;
    }

    public int getIndex() {
        return index;
    }

    public String getValue(){return value;}
}
