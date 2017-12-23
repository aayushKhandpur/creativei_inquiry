package creativei.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 12/17/2017.
 */
@Entity
@Table(name = "Inquiry_Address")
public class InquiryAddress extends BaseEntity implements Serializable {

    @OneToOne
    private Inquiry inquiry;
    @Column(nullable = false, unique = true)
    private String pincode;
    @Column(nullable = false)
    private String country="INDIA";
    @Column(nullable = false)
    private String city="JAIPUR";
    @Column(nullable = false)
    private String area;
    @Column(name = "address_line_1",nullable = false)
    private String addressLine1;
    @Column(name="address_line_2",nullable = false)
    private String addressLine2;
    @Column(nullable = false)
    private boolean is_current = true;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public boolean is_current() {
        return is_current;
    }

    public void setIs_current(boolean is_current) {
        this.is_current = is_current;
    }



}
