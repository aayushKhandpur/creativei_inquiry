package creativei.entity;

import creativei.enums.*;
import creativei.helper.constant.DbConstraints;
import creativei.vo.InquiryVo;
import org.hibernate.validator.constraints.Email;
import util.LocalizationUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by user on 12/16/2017.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email",name= DbConstraints.INQUIRY_EMAIL_UNIQUE),
        @UniqueConstraint(columnNames = "phone_number",name =DbConstraints.INQUIRY_PHONE_UNIQUE),
    })

public class Inquiry  extends BaseEntity implements Serializable  {
    public Inquiry(){}

    public Inquiry(InquiryVo inquiryVo) throws ParseException {
        this.setId(inquiryVo.getId());
        this.name=inquiryVo.getName();
        this.areaOfInterest=AreaOfInterest.stringToEnum(inquiryVo.getAreaOfInterest());
        this.phoneNumber=inquiryVo.getMobile();
        this.email=inquiryVo.getEmail();
        this.highestEducation=EducationQualification.stringToEnum(inquiryVo.gethQualification());
        this.dob= LocalizationUtil.stringToDateConverter(inquiryVo.getDob()==null?"1996/10/31":inquiryVo.getDob());
        this.gender=Gender.stringToEnum(inquiryVo.getGender());
        this.computerKnowledge=ComputerKnowledge.stringToEnum(inquiryVo.getComputerKnowledge());
        if(inquiryVo.getAddress()!=null)
            this.inquiryAddress=new InquiryAddress(inquiryVo.getAddress());
        if(inquiryVo.getEducation()!=null)
            this.inquiryEducation=new InquiryEducation(inquiryVo.getEducation());
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
    @ManyToOne
    private Branch branch;
    private Date dob;
    @Column(name = "area_of_interest")
    private AreaOfInterest areaOfInterest;
    @OneToOne(cascade=CascadeType.ALL)
    private InquiryAddress inquiryAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private InquiryEducation inquiryEducation;

    public InquiryEducation getInquiryEducation() {
        return inquiryEducation;
    }

    public void setInquiryEducation(InquiryEducation inquiryEducation) {
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

    public EducationQualification getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(EducationQualification highestEducation) {
        this.highestEducation = highestEducation;
    }

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

    public void setComputerKnowledge(ComputerKnowledge computerKnowledge) {
        this.computerKnowledge = computerKnowledge;
    }

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
