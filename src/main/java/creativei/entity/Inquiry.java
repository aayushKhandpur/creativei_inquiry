package creativei.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by user on 12/16/2017.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "ph_num"),
        @UniqueConstraint(columnNames = "alt_num")
})

public class Inquiry extends BaseEntity implements Serializable {

    @Column(nullable = false,name="f_name")
    private String fName;
    @Column(name = "l_name")
    private String lName;
    @Column(name="inq_date")
    private Date inqDate;
    private String gender;
    @Column(nullable = false,name="ph_num")
    private String phNum;
    @Column(nullable = false)
    private String email;
    @Column(nullable=false,name = "h_qual")
    private String hQual;
    private String occ;
    @Column(name="alt_num")
    private String altNum;
    @Column(nullable = false,name="comp_knw")
    private String compKnw;
    @ManyToOne
    private Branch branch;


    @OneToOne
    private InquiryAddress inquiryAddress;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }



    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getInqDate() {
        return inqDate;
    }

    public void setInqDate(Date inqDate) {
        this.inqDate = inqDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gethQual() {
        return hQual;
    }

    public void sethQual(String hQual) {
        this.hQual = hQual;
    }

    public String getOcc() {
        return occ;
    }

    public void setOcc(String occ) {
        this.occ = occ;
    }

    public String getAltNum() {
        return altNum;
    }

    public void setAltNum(String altNum) {
        this.altNum = altNum;
    }

    public String getCompKnw() {
        return compKnw;
    }

    public void setCompKnw(String compKnw) {
        this.compKnw = compKnw;
    }


}
