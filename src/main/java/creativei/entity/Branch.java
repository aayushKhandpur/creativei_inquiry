package creativei.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by Aayush on 12/15/2017.
 */
@Entity
public class Branch extends BaseEntity implements Serializable {
    @Column(unique = true, nullable = false)
    private String name;

    public Branch(String name) {
        this.name = name;
    }
}
