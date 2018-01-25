package creativei.enums;

public enum StatusId {
    TO_CALL_BACK("To Call Back"),
    NOT_INTERESTED_NOW("Not Intersted Now"),
    NOT_INTERESTED("Not Interested"),
    ENROLLED_WITH_COMPITITOR("Enrolled with competitor"),
    ENROLLED("Enrolled");

    private String value;

    private StatusId(String value){
        this.value=value;
    }

    public String getValue() {return value;}
}
