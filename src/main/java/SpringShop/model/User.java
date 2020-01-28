package SpringShop.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "USERS")
public class User {
    private Integer userId;
    private String username;
    private String password;
    private boolean isActivated;
    private UserRole userRole;
    private Address address;

    public User() {
        isActivated=false;
        userRole=UserRole.USER;
        address=null;
    }

    public User(Integer userId, String username, String password, boolean isActivated, UserRole userRole, Address address) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.isActivated = isActivated;
        this.userRole = userRole;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    public Integer getUserId() {
        return userId;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActivated() {
        return isActivated;
    }

    @Enumerated
    public UserRole getUserRole() {
        return userRole;
    }

    @OneToOne
    @JoinColumn(name = "addressId")
    public Address getAddress() {
        return address;
    }



    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

}






