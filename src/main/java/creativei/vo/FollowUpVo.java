package creativei.vo;

import java.util.Date;

public class FollowUpVo {
    private String followUpDate;
    private String followUpType;
    private String followUpStatus;
    private String remark;
    private String caseIndex;
    private String subStatus;

    public String getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getFollowUpType() {
        return followUpType;
    }

    public void setFollowUpType(String followUpType) {
        this.followUpType = followUpType;
    }

    public String getFollowUpStatus() {
        return followUpStatus;
    }

    public void setFollowUpStatus(String followUpStatus) {
        this.followUpStatus = followUpStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCaseIndex() {
        return caseIndex;
    }

    public void setCaseIndex(String caseIndex) {
        this.caseIndex = caseIndex;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }
}
