package creativei.entity;

import creativei.enums.CaseIndex;
import creativei.enums.FollowUpSubStatus;
import creativei.enums.FollowUpType;
import creativei.enums.FollowUpStatus;
import creativei.exception.NoDataAvailable;
import creativei.helper.ResponseHelper;
import creativei.service.InquiryService;
import creativei.vo.FollowUpVo;
import org.springframework.beans.factory.annotation.Autowired;
import util.LocalizationUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

@Entity
@Table(name = "Follow_Up")
public class FollowUp extends BaseEntity implements Serializable {

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    private Inquiry inquiry;
    @Column(name = "follow_up_date")
    private Date followUpDate;
    private FollowUpType type;
    private FollowUpStatus status;
    private String remark;
    @Column(name = "case_index")
    private CaseIndex caseIndex;
    @Column(name = "sub_status")
    private FollowUpSubStatus subStatus;

    public FollowUp() {
    }

    public FollowUp(FollowUpVo followUpVo) throws ParseException, NoDataAvailable {
        this.setId(followUpVo.getId());
        this.followUpDate = LocalizationUtil.stringToDateConverter(followUpVo.getFollowUpDate());
        this.type = FollowUpType.stringToEnum(followUpVo.getFollowUpType());
        this.status = FollowUpStatus.stringToEnum(followUpVo.getFollowUpStatus());
        this.remark = followUpVo.getRemark();
        this.caseIndex = CaseIndex.stringToEnum(followUpVo.getCaseIndex());
        this.subStatus = FollowUpSubStatus.stringToEnum(followUpVo.getSubStatus());
        this.inquiry=new Inquiry(followUpVo.getInquiryId());
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

    public FollowUpType getType() {
        return type;
    }

    public void setType(FollowUpType type) {
        this.type = type;
    }

    public FollowUpSubStatus getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(FollowUpSubStatus subStatus) {
        this.subStatus = subStatus;
    }

    public FollowUpStatus getStatus() {
        return status;
    }

    public void setStatus(FollowUpStatus status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CaseIndex getCaseIndex() {
        return caseIndex;
    }

    public void setCaseIndex(CaseIndex caseIndex) {
        this.caseIndex = caseIndex;
    }
}
