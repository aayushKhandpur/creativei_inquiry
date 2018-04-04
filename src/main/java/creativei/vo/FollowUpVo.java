package creativei.vo;

import creativei.entity.FollowUp;
import creativei.enums.CaseIndex;
import creativei.enums.FollowUpStatus;
import creativei.enums.FollowUpSubStatus;
import creativei.enums.FollowUpType;
import creativei.util.LocalizationUtil;

public class FollowUpVo {
    private Long id;
    private String followUpDate;
    private String followUpType;
    private String followUpStatus;
    private String remark;
    private String caseIndex;
    private String subStatus;
    private Long inquiryId;

    public FollowUpVo(){}

    public FollowUpVo(FollowUp followUp){
        this.setId(followUp.getId());
        this.setCaseIndex(CaseIndex.enumToString(followUp.getCaseIndex()));
        this.setFollowUpDate(LocalizationUtil.getFormattedDate(followUp.getFollowUpDate()));
        this.setFollowUpStatus(FollowUpStatus.enumToString(followUp.getStatus()));
        this.setFollowUpType(FollowUpType.enumToString(followUp.getType()));
        this.setRemark(followUp.getRemark());
        this.setSubStatus(FollowUpSubStatus.enumToString(followUp.getSubStatus()));
        if(followUp.getInquiry() != null)
            this.inquiryId = followUp.getInquiry().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

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
