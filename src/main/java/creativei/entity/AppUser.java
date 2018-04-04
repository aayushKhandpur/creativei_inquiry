package creativei.entity;

import creativei.enums.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class AppUser extends BaseEntity implements Serializable {
    private String userId;
    private String password;
    private String name;
    @Column(name = "user_role")
    private UserRole userRole;

    public AppUser(String userId, String password, String name, UserRole userRole) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
