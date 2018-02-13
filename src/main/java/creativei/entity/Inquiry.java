package creativei.entity;

import creativei.enums.*;
import creativei.vo.InquiryVo;
import org.hibernate.validator.constraints.Email;
import util.LocalizationUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Inquiry  extends BaseEntity implements Serializable  {
    public Inquiry(){}

    public Inquiry(InquiryVo inquiryVo) throws ParseException {
        this.setId(inquiryVo.getId());
        this.name=inquiryVo.getName()==null||inquiryVo.getName().isEmpty()?null:inquiryVo.getName();
        this.areaOfInterest=AreaOfInterest.stringToEnum(inquiryVo.getAreaOfInterest());
        this.phoneNumber=inquiryVo.getMobile()==null||inquiryVo.getMobile().isEmpty()?null:inquiryVo.getMobile();
        this.email=inquiryVo.getEmail()==null||inquiryVo.getEmail().isEmpty()?null:inquiryVo.getEmail();
        this.highestEducation=EducationQualification.stringToEnum(inquiryVo.gethQualification());
        this.dob= LocalizationUtil.stringToDateConverter(inquiryVo.getDob());
        this.gender=Gender.stringToEnum(inquiryVo.getGender());
        this.inquiryStatus=InquiryStatus.stringToEnum(inquiryVo.getInquiryStatus())==null?InquiryStatus.OPEN:InquiryStatus.stringToEnum(inquiryVo.getInquiryStatus());
        this.computerKnowledge=ComputerKnowledge.stringToEnum(inquiryVo.getComputerKnowledge());
        this.closingStatus =FollowUpStatus.stringToEnum(inquiryVo.getClosingStatus());
        this.closingSubStatus=FollowUpSubStatus.stringToEnum(inquiryVo.getClosingSubStatus());
        this.remark=inquiryVo.getClosingRemark();
        if(inquiryVo.getAddress()!=null)
            this.inquiryAddress=new InquiryAddress(inquiryVo.getAddress());
        if(inquiryVo.getEducation()!=null) {
            for(int i=0;i<inquiryVo.getEducation().size();i++) {
                InquiryEducation inquiryEducations = new InquiryEducation(inquiryVo.getEducation().get(i));
                this.inquiryEducation.add(inquiryEducations);
            }
        }
        if(inquiryVo.getGuardian()!=null)
            this.inquiryGuardian=new InquiryGuardian(inquiryVo.getGuardian());
        if(inquiryVo.getMarketing()!=null)
            this.inquiryMarketing=new InquiryMarketing(inquiryVo.getMarketing());
    }

    public Inquiry(Long id){
        this.setId(id);
    }
    @Column(nullable = false)
    private String name;
    @Column(name = "inquiry_date", nullable = false)
    private Date inquiryDate=new Date();
    private Gender gender;
    @Column(nullable = false,name="phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    @Email
    private String email;
    @Column(nullable=false,name = "highest_education")
    private EducationQualification highestEducation;
    private Occupation occupation;
    @Column(name="alternate_phone")
    private String alternatePhone;
    @Column(name="computer_knowledge")
    private ComputerKnowledge computerKnowledge;
    @Column(name = "inquiry_status")
    private InquiryStatus inquiryStatus=InquiryStatus.OPEN;
    @ManyToOne
    private Branch branch;
    private Date dob;
    @Column(name = "area_of_interest")
    private AreaOfInterest areaOfInterest;
    @OneToOne(cascade = CascadeType.ALL)
    private InquiryAddress inquiryAddress;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inquiry")
    private List<InquiryEducation> inquiryEducation=new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private InquiryGuardian inquiryGuardian;
    @OneToOne(cascade = CascadeType.ALL)
    private InquiryMarketing inquiryMarketing;
    @Column(name = "closing_status")
    private FollowUpStatus closingStatus;
    @Column(name = "closing_substatus")
    private FollowUpSubStatus closingSubStatus;
    @Column(name = "closing_remark")
    private String remark;

    public FollowUpStatus getClosingStatus() {
        return closingStatus;
    }

    public void setClosingStatus(FollowUpStatus closingStatus) {
        this.closingStatus = closingStatus;
    }

    public FollowUpSubStatus getClosingSubStatus() {
        return closingSubStatus;
    }

    public void setClosingSubStatus(FollowUpSubStatus closingSubStatus) {
        this.closingSubStatus = closingSubStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public InquiryMarketing getInquiryMarketing() { return inquiryMarketing;}

    public void setInquiryMarketing(InquiryMarketing inquiryMarketing) { this.inquiryMarketing = inquiryMarketing;}

    public InquiryGuardian getInquiryGuardian() {  return inquiryGuardian;    }

    public void setInquiryGuardian(InquiryGuardian inquiryGuardian) { this.inquiryGuardian = inquiryGuardian; }

    public List<InquiryEducation> getInquiryEducation() {
        return inquiryEducation;
    }

    public void setInquiryEducation(List<InquiryEducation> inquiryEducation) {
        this.inquiryEducation = inquiryEducation;
    }

    public Date getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(Date inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public InquiryAddress getInquiryAddress() {
        return inquiryAddress;
    }

    public void setInquiryAddress(InquiryAddress inquiryAddress) {
        this.inquiryAddress = inquiryAddress;
    }

    public Branch getBranch() { return branch; }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InquiryStatus getInquiryStatus() {return inquiryStatus;}

    public void setInquiryStatus(InquiryStatus inquiryStatus) {this.inquiryStatus = inquiryStatus;}

    public EducationQualification getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(EducationQualification highestEducation) { this.highestEducation = highestEducation;}

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public ComputerKnowledge getComputerKnowledge() {
        return computerKnowledge;
    }

    public void setComputerKnowledge(ComputerKnowledge computerKnowledge) {this.computerKnowledge = computerKnowledge;}

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public AreaOfInterest getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(AreaOfInterest areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

}
