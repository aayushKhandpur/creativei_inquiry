package creativei.entity;

import creativei.manager.impl.LocalityMangerImpl;
import creativei.vo.AddressVo;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(indexes = @Index(columnList = "name,pincode"))
public class Locality extends BaseEntity implements Serializable {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String pincode;
    @ManyToOne
    private City city;

    public Locality() {
    }

    public Locality(Long locationId) {
        this.setId(locationId);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
