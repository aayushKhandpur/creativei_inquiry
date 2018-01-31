package creativei.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum FollowUpStatus {
    CALL_BACK("To Call Back/Follow Up"),
    FOLLOW_UP_LATER("Not Interested Now/To Follow Up Later"),
    NOT_INTERESTED("Not Intersted Now/Lead Mismatch"),
    ENROLLED_W_COMPITITOR("Enrolled with competitor"),
    ENROLLED("Enrolled"),
    NOT_ELIGIBLE("Not Eligible");

    private String value;

    private FollowUpStatus(String value){
        this.value=value;
    }

    public String getValue() {return value;}

    public static List<String> getEnumValue(){
       return Stream.of(FollowUpStatus.values()).map(FollowUpStatus->FollowUpStatus.value).collect(Collectors.toList());
    }
}
