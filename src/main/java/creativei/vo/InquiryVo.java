package creativei.vo;

import creativei.entity.Inquiry;
import creativei.entity.InquiryEducation;
import creativei.enums.*;
import util.LocalizationUtil;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class InquiryVo {
    private Long id;
    private String name;
    private String mobile;
    private String email;
    private String inquiryStatus;
    private String dob;
    private String inquiryDate;
    private String hQualification;
    private String areaOfInterest;;
    private String computerKnowledge;
    private AddressVo address;
    private String gender;
    private List<EducationVo> educations=new ArrayList<>();
    private GuardianVo guardian;
    private MarketingVo marketing;
    private String closingStatus;
    private String closingSubStatus;
    private String closingRemark;
    private String occupation;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public InquiryVo(){}

    public InquiryVo(Inquiry inquiry){
        this.setId(inquiry.getId());
        this.setAreaOfInterest(AreaOfInterest.enumToString(inquiry.getAreaOfInterest()));
        this.setName(inquiry.getName());
        this.setDob(LocalizationUtil.getFormattedDate(inquiry.getDob()));
        this.sethQualification(EducationQualification.enumToString(inquiry.getHighestEducation()));
        this.setEmail(inquiry.getEmail());
        this.setMobile(inquiry.getPhoneNumber());
        this.setId(inquiry.getId());
        this.setInquiryStatus(InquiryStatus.enumToString(inquiry.getInquiryStatus()));
        this.setInquiryDate(LocalizationUtil.getFormattedDate(inquiry.getInquiryDate()));
        this.setGender(Gender.enumToString(inquiry.getGender()));
        this.setComputerKnowledge(ComputerKnowledge.enumToString(inquiry.getComputerKnowledge()));
        this.setClosingStatus(FollowUpStatus.enumToString(inquiry.getClosingStatus()));
        this.setClosingSubStatus(FollowUpSubStatus.enumToString(inquiry.getClosingSubStatus()));
        this.setClosingRemark(inquiry.getRemark());
        if(inquiry.getInquiryAddress()!=null)
            this.setAddress(new AddressVo(inquiry.getInquiryAddress()));
        if (inquiry.getInquiryEducations() != null)
            for(InquiryEducation inquiryEducation:inquiry.getInquiryEducations()){
                this.educations.add(new EducationVo(inquiryEducation));
            }
        if (inquiry.getInquiryGuardian() != null)
            this.setGuardian( new GuardianVo(inquiry.getInquiryGuardian()));
        if (inquiry.getInquiryMarketing() != null)
            this.setMarketing(new MarketingVo(inquiry.getInquiryMarketing()));
    }

    public String getClosingStatus() {
        return closingStatus;
    }

    public void setClosingStatus(String closingStatus) {
        this.closingStatus = closingStatus;
    }

    public String getClosingSubStatus() {
        return closingSubStatus;
    }

    public void setClosingSubStatus(String closingSubStatus) {
        this.closingSubStatus = closingSubStatus;
    }

    public String getClosingRemark() {
        return closingRemark;
    }

    public void setClosingRemark(String closingRemark) {
        this.closingRemark = closingRemark;
    }

    public MarketingVo getMarketing() {
        return marketing;
    }

    public void setMarketing(MarketingVo marketing) {
        this.marketing = marketing;
    }

    public GuardianVo getGuardian() {
        return guardian;
    }

    public void setGuardian(GuardianVo guardian) {
        this.guardian = guardian;
    }

    public String getComputerKnowledge() {return computerKnowledge;    }

    public void setComputerKnowledge(String computerKnowledge) {this.computerKnowledge = computerKnowledge;}

    public String getInquiryDate() { return inquiryDate;    }

    public void setInquiryDate(String inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInquiryStatus() { return inquiryStatus;}

    public void setInquiryStatus(String inquiryStatus) { this.inquiryStatus = inquiryStatus;}

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String gethQualification() { return hQualification;   }

    public void sethQualification(String hQualification) {
        this.hQualification = hQualification;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public AddressVo getAddress() {
        return address;
    }

    public void setAddress(AddressVo address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EducationVo> getEducation() {    return educations;    }

    public void setEducation(List<EducationVo> education) {  this.educations = education;}
}
