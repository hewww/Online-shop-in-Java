package SpringShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USERS")
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String mail;
    private boolean isActivated;
    private UserRole userRole;
    private Address address;
    private List<Order> orders = new ArrayList<Order>();

    public User() {
        isActivated=false;
        userRole=UserRole.USER;
    }

    public User(Integer userId, String username, String password, String mail, boolean isActivated, UserRole userRole) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.isActivated = isActivated;
        this.userRole = userRole;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    public Integer getUserId() {
        return userId;
    }


    @NotNull
    public String getUsername() {
        return username;
    }

    @NotNull
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


    public String getMail() {
        return mail;
    }

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    public List<Order> getOrders() {
        return orders;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy = "user")
    public Address getAddress(){
        return address;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public void setAddress(Address address) { this.address=address;}

}






