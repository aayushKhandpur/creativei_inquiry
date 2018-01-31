package creativei.vo;

import creativei.enums.CaseIndex;
import creativei.enums.FollowUpStatus;
import creativei.enums.FollowUpSubStatus;
import creativei.enums.FollowUpType;

import java.util.List;
import java.util.Map;

public class FollowUpServerInfo {
    private List<String> followUpType,followUpStatus,followUpSubStatus,caseIndex;
    public FollowUpServerInfo(){
        this.followUpType= FollowUpType.getEnumValue();
        this.followUpStatus= FollowUpStatus.getEnumValue();
        this.caseIndex= CaseIndex.getAllEnum();
        this.followUpSubStatus= FollowUpSubStatus.getEnumValue();
    }

    public List<String> getFollowUpType() {
        return followUpType;
    }

    public List<String> getFollowUpStatus() {
        return followUpStatus;
    }

    public List<String>  getCaseIndex() {
        return caseIndex;
    }

    public List<String> getFollowUpSubStatus() {
        return followUpSubStatus;
    }
}
