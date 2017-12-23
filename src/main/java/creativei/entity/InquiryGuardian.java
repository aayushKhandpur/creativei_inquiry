package creativei.entity;

import creativei.enums.Occupation;
import creativei.enums.Relation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by user on 12/19/2017.
 */
@Entity
@Table(name="inquiry_guardian")
public class InquiryGuardian extends BaseEntity implements Serializable {


    @OneToOne
    private Inquiry inquiry;
    @Column(nullable = false)
    private String name;
    @Column(nullable=false)
    private Relation relation;
    @Column(name="phone_num",nullable = false)
    private String phoneNum;
    @Column(name="alternate_num")
    private String altNum;
    private String email;
    private Occupation occ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAltNum() {
        return altNum;
    }

    public void setAltNum(String altNum) {
        this.altNum = altNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Occupation getOcc() {
        return occ;
    }

    public void setOcc(Occupation occ) {
        this.occ = occ;
    }
}
