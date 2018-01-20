package creativei.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class State extends BaseEntity implements Serializable {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,name="is_default")
    private Boolean isDefault;
    @Column(nullable = false)
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
