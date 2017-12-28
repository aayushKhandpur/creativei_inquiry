package creativei.vo;

import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.enums.AreaOfInterest;
import creativei.enums.EducationQualification;
import creativei.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.lang.*;
/**
 * Created by user on 12/24/2017.
 */
public class InquiryVo {
    private String name;
    private String mobile;
    private String email;
    private String dob;
    private EducationQualification hQualification;
    private AreaOfInterest areaOfInterest;;
    private AddressVo address;
    private Gender gender;
    private Long id;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public EducationQualification gethQualification() {
        return hQualification;
    }

    public void sethQualification(EducationQualification hQualification) {
        this.hQualification = hQualification;
    }

    public AreaOfInterest getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(AreaOfInterest areaOfInterest) {
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



}
