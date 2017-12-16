package creativei.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by user on 12/16/2017.
 */
@Entity
@Table(name="Inquiry")

public class Inquiry extends BaseEntity implements Serializable {

    @Column
    private String f_name;
    @Column
    private String l_name;
    @Column
    private Date date;
    @Column
    private String gender;
    @Column
    private String ph_num;
    @Column
    private String email;
    @Column
    private String h_qual;
    @Column
    private String occ;
    @Column
    private String alt_num;
    @Column
    private String comp_knw;
    @Column
    private Branch branch_id;

    public Branch getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Branch branch_id) {
        this.branch_id = branch_id;
    }



    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPh_num() {
        return ph_num;
    }

    public void setPh_num(String ph_num) {
        this.ph_num = ph_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getH_qual() {
        return h_qual;
    }

    public void setH_qual(String h_qual) {
        this.h_qual = h_qual;
    }

    public String getOcc() {
        return occ;
    }

    public void setOcc(String occ) {
        this.occ = occ;
    }

    public String getAlt_num() {
        return alt_num;
    }

    public void setAlt_num(String alt_num) {
        this.alt_num = alt_num;
    }

    public String getComp_knw() {
        return comp_knw;
    }

    public void setComp_knw(String comp_knw) {
        this.comp_knw = comp_knw;
    }


}
