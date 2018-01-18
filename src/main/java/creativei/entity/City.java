package creativei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;
@Entity

public class City extends BaseEntity implements Serializable{
    @Column(nullable = false)
    private String name;
    @Column(name = "is_default",nullable = false)
    private Boolean isDefault;
    @ManyToOne
    @Column(name = "state_id",nullable = false)
    private State state;

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
