package creativei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints ={
        @UniqueConstraint(columnNames="name"),
        @UniqueConstraint(columnNames = "mobile")
        })
public class Branch extends BaseEntity implements Serializable {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    private String alternate_name;
    @Column(nullable = false)
    private String contact_number;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable = false)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAlternate_name() {
        return alternate_name;
    }

    public void setAlternate_name(String alternate_name) {
        this.alternate_name = alternate_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
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

    public Branch(String name) {
        this.name = name;
    }
}
